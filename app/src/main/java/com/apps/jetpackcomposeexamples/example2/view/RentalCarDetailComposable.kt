package com.apps.jetpackcomposeexamples.example2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.apps.jetpackcomposeexamples.ui.theme.RentalSecondary
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun RentalCarDetailScreen() {
    rememberSystemUiController().apply {
        setSystemBarsColor(RentalSecondary, darkIcons = false)
        setNavigationBarColor(RentalSecondary, false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(RentalSecondary)
    ) {

    }
}