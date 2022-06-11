package com.apps.jetpackcomposeexamples.main.model

data class MainModel(
    val exampleName: String = "",
    val showcase: Showcase = Showcase.DEFAULT
) {
    val mock: ArrayList<MainModel>
        get() {
            return arrayListOf(
                MainModel("Example1: Event App", Showcase.EVENT_APP),
                MainModel("Example2: Rental Car App", Showcase.RENTAL_CAR_APP),
                MainModel("Example3: Travel App", Showcase.TRAVEL_APP)
            )
        }
}

enum class Showcase {
    EVENT_APP,
    RENTAL_CAR_APP,
    TRAVEL_APP,
    DEFAULT
}