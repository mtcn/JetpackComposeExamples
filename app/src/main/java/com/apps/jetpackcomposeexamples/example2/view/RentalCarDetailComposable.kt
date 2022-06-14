package com.apps.jetpackcomposeexamples.example2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apps.jetpackcomposeexamples.R
import com.apps.jetpackcomposeexamples.example2.model.CarSpec
import com.apps.jetpackcomposeexamples.example2.model.RentalCarModel
import com.apps.jetpackcomposeexamples.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun RentalCarDetailScreen(car: RentalCarModel) {
    rememberSystemUiController().apply {
        setSystemBarsColor(RentalSecondary, darkIcons = false)
        setNavigationBarColor(LightGrey2, false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(LightGrey2)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f)
                .background(RentalSecondary)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 24.dp, top = 16.dp, end = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .background(RentalPrimary, RoundedCornerShape(12.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "",
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                            .align(Alignment.Center)
                    )
                }

                Text(
                    text = car.brand,
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = TextStyle(fontSize = 20.sp, fontFamily = MuliRegular, color = White)
                )

                Image(
                    painter = painterResource(id = car.dealerImage),
                    contentDescription = "",
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .align(Alignment.CenterVertically), contentScale = ContentScale.Crop

                )
            }

            Text(
                text = car.model,
                modifier = Modifier
                    .padding(start = 24.dp, top = 24.dp)
                    .fillMaxWidth(0.7f)
                    .wrapContentHeight(),
                style = TextStyle(
                    fontSize = 18.sp, fontFamily = MuliRegular, color = White
                )
            )

            Image(
                painter = painterResource(id = car.image),
                contentDescription = "",
                modifier = Modifier
                    .padding(28.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(),
            contentPadding = PaddingValues(top = 36.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            items(car.specs) {
                CarSpecItem(it)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "$ ${car.price}/day",
                modifier = Modifier
                    .defaultMinSize(minHeight = 56.dp)
                    .wrapContentWidth()
                    .wrapContentHeight(),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = MuliBold,
                    color = White,
                    textAlign = TextAlign.Center
                )
            )
            Button(
                modifier = Modifier
                    .width(164.dp)
                    .height(56.dp),
                elevation = ButtonDefaults.elevation(defaultElevation = 8.dp),
                onClick = {},
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = RentalPrimary,
                    contentColor = RentalSecondary
                )
            ) {

                Text(
                    text = "Book now",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontFamily = MuliSemiBold,
                        fontSize = 20.sp,
                        color = White
                    )
                )
            }
        }
    }
}

@Composable
fun CarSpecItem(spec: CarSpec) {
    Column(
        modifier = Modifier
            .height(128.dp)
            .width(128.dp)
            .padding(8.dp)
            .background(RentalSecondary, RoundedCornerShape(12.dp)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = spec.icon),
            colorFilter = ColorFilter.tint(White),
            contentDescription = "",
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
        )

        Text(
            text = spec.title,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MuliRegular,
                color = LightGrey2,
                textAlign = TextAlign.Center
            )
        )

        Text(
            text = spec.desc,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = MuliRegular,
                color = White,
                textAlign = TextAlign.Center
            )
        )
    }

}