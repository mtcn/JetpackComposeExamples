package com.apps.jetpackcomposeexamples.example1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.apps.jetpackcomposeexamples.R

@Composable
@Preview
fun TestExampleHeader(name: String? = null) {
    Text(text = "Hello $name!")
}


@Composable
@Preview
fun TestExampleHeader2(name: String? = null) {
    Text(text = "Hello2 $name!")
}

@OptIn(ExperimentalUnitApi::class)
@Composable
@Preview
fun asdas() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFF2F2F2))
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Happy Meal",
                style = TextStyle(
                    fontSize = TextUnit(20f, TextUnitType.Sp)
                )
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = "800 calories",
                style = TextStyle(
                    fontSize = TextUnit(17f, TextUnitType.Sp)
                )
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = "$5.99",
                style = TextStyle(
                    color = Color(0xFF85bb65),
                    fontSize = TextUnit(17f, TextUnitType.Sp)
                )
            )
        }
    }
}