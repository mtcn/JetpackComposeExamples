package com.apps.jetpackcomposeexamples.main

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.apps.jetpackcomposeexamples.main.model.MainModel

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val showcaseState: MutableState<List<MainModel>?> = mutableStateOf(null)

    init {
        showcaseState.value = MainModel().mock
    }
}
