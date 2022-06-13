package com.apps.jetpackcomposeexamples.example2

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.apps.jetpackcomposeexamples.example2.model.RentalCarModel

class RentalCarViewModel(application: Application) : AndroidViewModel(application) {

    val rentalCarState: MutableState<RentalCarModel?> = mutableStateOf(null)

    init {
        rentalCarState.value = RentalCarModel().mock
    }
}