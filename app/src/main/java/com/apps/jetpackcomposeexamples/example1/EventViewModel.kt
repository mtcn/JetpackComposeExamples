package com.apps.jetpackcomposeexamples.example1

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.apps.jetpackcomposeexamples.example1.model.EventModel

class EventViewModel(application: Application) : AndroidViewModel(application) {

    val eventState: MutableState<List<EventModel>?> = mutableStateOf(null)

    init {
        eventState.value = EventModel().mock
    }
}
