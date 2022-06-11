package com.apps.jetpackcomposeexamples.example1.model

import androidx.annotation.DrawableRes

data class EventModel(
    val name: String = "",
    val dDate: String = "",
    val location: String = "",
    val details: String = "",
    val sponsors: ArrayList<String> = arrayListOf(),
    val about: ArrayList<String> = arrayListOf(),
    @DrawableRes val logo: Int = 0,
    @DrawableRes val headerImage: Int = 0,
) {
    val mock: ArrayList<EventModel>
        get() {
            return arrayListOf()
        }

}
