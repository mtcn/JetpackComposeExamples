package com.apps.jetpackcomposeexamples.example1.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.apps.jetpackcomposeexamples.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventModel(
    val name: String = "",
    val date: String = "",
    val location: String = "",
    val details: String = "",
    val sponsors: ArrayList<Int> = arrayListOf(),
    val about: ArrayList<String> = arrayListOf(),
    @DrawableRes val mainLogo: Int = 0,
    @DrawableRes val logo: Int = 0,
    @DrawableRes val headerImage: Int = 0,
) : Parcelable {

    val mock: ArrayList<EventModel>
        get() {
            return arrayListOf(
                EventModel(
                    name = "Webrazzi Digital 2022",
                    date = "29.09.2022 - 30.09.2022",
                    location = "Istanbul",
                    details = "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui. In malesuada enim in dolor euismod, id commodo mi consectetur. Curabitur at vestibulum nisi…",
                    sponsors = arrayListOf(),
                    about = arrayListOf(
                        "Marketing",
                        "Technology",
                        "Web3",
                        "NFT",
                        "Big Data",
                        "Digital"
                    ),
                    mainLogo = R.drawable.ic_event_webrazzi,
                    logo = R.drawable.ic_event_webrazzi_logo,
                    headerImage = R.drawable.ic_event_webrazzi_header
                ),
                EventModel(
                    name = "Summer Night Sky ‘19",
                    date = "01.10.2022 - 05.10.2022",
                    location = "Moon",
                    details = "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui. In malesuada enim in dolor euismod, id commodo mi consectetur. Curabitur at vestibulum nisi…",
                    sponsors = arrayListOf(),
                    about = arrayListOf(
                        "Future",
                        "Space",
                        "Mars",
                        "Nasa",
                        "Mars Rover",
                        "Galaxies"
                    ),
                    mainLogo = R.drawable.ic_event_nasa,
                    logo = R.drawable.ic_event_nasa_logo,
                    headerImage = R.drawable.ic_event_nasa_header
                )
            )
        }

}
