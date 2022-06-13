package com.apps.jetpackcomposeexamples.example2.model

import androidx.annotation.DrawableRes

data class RentalCarModel(
    val brand: String = "",
    val model: String = "",
    val topSpeed: String = "",
    val power: String = "",
    val seats: Int = 0,
    val doors: Int = 0,
    val fuel: Int = 0,
    val sensor: Boolean = true,
    val price: Int = 0,
    val rating: Double = 0.0,
    @DrawableRes val image: Int = 0
) {
    val mock: RentalCarModel
        get() {
            return RentalCarModel()
        }
}