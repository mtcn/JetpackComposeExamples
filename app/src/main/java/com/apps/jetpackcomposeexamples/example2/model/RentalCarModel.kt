package com.apps.jetpackcomposeexamples.example2.model

import androidx.annotation.DrawableRes
import com.apps.jetpackcomposeexamples.R

data class RentalCarModel(
    val brand: String = "",
    val model: String = "",
    val price: Int = 0,
    val specs: ArrayList<CarSpec> = arrayListOf(),
    @DrawableRes val dealerImage: Int = 0,
    @DrawableRes val image: Int = 0
) {
    val mock: RentalCarModel
        get() {
            return RentalCarModel(
                brand = "FERRARI",
                model = "2022 Ferrari 812 GTS",
                price = 250,
                specs = arrayListOf(
                    CarSpec(
                        "TOP SPEED",
                        "280 km/h",
                        R.drawable.ic_rental_speedometer
                    ),
                    CarSpec(
                        "POWER",
                        "490 HP",
                        R.drawable.ic_rental_horsepower
                    ),
                    CarSpec(
                        "SEATS",
                        "4",
                        R.drawable.ic_rental_seat
                    ),
                    CarSpec(
                        "DOORS",
                        "2",
                        R.drawable.ic_rental_car_door
                    ),
                    CarSpec(
                        "FUEL",
                        "65L",
                        R.drawable.ic_rental_fuel
                    ),
                    CarSpec(
                        "SENSOR",
                        "Available",
                        R.drawable.ic_rental_sensor
                    )
                ),
                dealerImage = R.drawable.ic_rental_pp,
                image = R.drawable.ic_rental_detail
            )
        }
}

data class CarSpec(
    val title: String,
    val desc: String,
    @DrawableRes val icon: Int
)