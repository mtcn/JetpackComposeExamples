package com.apps.jetpackcomposeexamples.example1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apps.jetpackcomposeexamples.R
import com.apps.jetpackcomposeexamples.example1.model.EventModel
import com.apps.jetpackcomposeexamples.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun EventDetailScreen(eventModel: EventModel) {
    rememberSystemUiController().apply {
        setSystemBarsColor(White, darkIcons = true)
        setNavigationBarColor(White, true)
    }
    Column(
        modifier = Modifier
            .background(White)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = eventModel.logo),
            contentDescription = "",
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )

        Image(
            painter = painterResource(id = eventModel.headerImage),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 16.dp)
        )

        Row {
            Column(modifier = Modifier.fillMaxWidth(0.75f)) {
                Text(
                    text = eventModel.name,
                    maxLines = 1,
                    style = TextStyle(
                        color = Black, fontSize = 20.sp, fontFamily = MuliBlack
                    ),
                    modifier = Modifier
                        .padding(top = 24.dp, start = 24.dp, end = 8.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = eventModel.date,
                    maxLines = 1,
                    style = TextStyle(
                        color = Color.LightGray,
                        fontSize = 16.sp,
                        fontFamily = MuliRegular
                    ),
                    modifier = Modifier
                        .padding(start = 24.dp, end = 8.dp)
                        .fillMaxWidth()
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_event_location),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 16.dp, top = 24.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .padding(top = 16.dp)
        )

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(LightGrey)
        )
        Text(
            text = "SPONSORS",
            modifier = Modifier.padding(top = 16.dp, start = 24.dp),
            style = TextStyle(fontFamily = MuliExtraBold, fontSize = 12.sp)
        )

        LazyRow(
            contentPadding = PaddingValues(
                start = 24.dp,
                top = 16.dp,
                bottom = 16.dp,
                end = 16.dp
            )
        ) {
            items(items = eventModel.sponsors) { item ->
                Image(
                    painter = painterResource(id = item),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(0.15f)
                        .padding(end = 8.dp),
                )
            }
        }

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
                .background(LightGrey)
        )

        Text(
            text = "EVENT TAGS",
            modifier = Modifier.padding(top = 16.dp, start = 24.dp),
            style = TextStyle(fontFamily = MuliExtraBold, fontSize = 12.sp)
        )

        LazyRow(
            contentPadding = PaddingValues(
                start = 24.dp,
                top = 16.dp,
                bottom = 16.dp,
                end = 16.dp
            )
        ) {
            items(items = eventModel.tags) { item ->
                Box(
                    modifier = Modifier
                        .wrapContentWidth()
                        .height(36.dp)
                        .padding(end = 6.dp)
                        .background(PaleMauve, RoundedCornerShape(8.dp))
                ) {
                    Text(
                        text = item,
                        modifier = Modifier
                            .padding(end = 8.dp, start = 8.dp)
                            .align(Alignment.Center),
                        style = TextStyle(
                            fontFamily = MuliExtraBold,
                            fontSize = 12.sp,
                            color = Fuchsia
                        )
                    )
                }

            }
        }

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
                .background(LightGrey)
        )

        Text(
            text = "ABOUT EVENT",
            modifier = Modifier.padding(top = 16.dp, start = 24.dp),
            style = TextStyle(fontFamily = MuliExtraBold, fontSize = 12.sp)
        )

        Text(
            text = eventModel.details,
            modifier = Modifier.padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 54.dp),
            style = TextStyle(fontFamily = MuliRegular, fontSize = 14.sp)
        )
    }
}
