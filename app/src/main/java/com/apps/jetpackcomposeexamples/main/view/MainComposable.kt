package com.apps.jetpackcomposeexamples.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.apps.jetpackcomposeexamples.main.model.MainModel
import com.apps.jetpackcomposeexamples.main.model.Showcase
import com.apps.jetpackcomposeexamples.ui.theme.EventPrimary
import com.apps.jetpackcomposeexamples.ui.theme.LightGrey
import com.apps.jetpackcomposeexamples.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun ShowcaseList(list: List<MainModel>, onClick: (s: Showcase) -> Unit) {
    rememberSystemUiController().apply {
        setSystemBarsColor(LightGrey, darkIcons = true)
        setNavigationBarColor(Color.LightGray, true)
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(color = Color.LightGray)
    ) {
        list.forEach {
            ShowcaseCard(it, onClick)
        }
    }
}

@OptIn(ExperimentalUnitApi::class, ExperimentalMaterialApi::class)
@Composable
fun ShowcaseCard(model: MainModel, onClick: (s: Showcase) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        color = White,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        onClick = {
            onClick(model.showcase)
        }
    ) {
        Text(
            text = model.exampleName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 24.dp, bottom = 24.dp, end = 16.dp),
            fontFamily = FontFamily.SansSerif,
            fontSize = TextUnit(18f, TextUnitType.Sp),
            textAlign = TextAlign.Start
        )
    }
}