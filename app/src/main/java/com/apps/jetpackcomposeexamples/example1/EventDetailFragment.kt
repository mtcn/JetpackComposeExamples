package com.apps.jetpackcomposeexamples.example1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.apps.jetpackcomposeexamples.example1.model.EventModel
import com.apps.jetpackcomposeexamples.example1.view.EventDetailScreen

class EventDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            arguments?.getParcelable<EventModel>("eventArg")?.let { event ->
                setContent { EventDetailScreen(event) }
            }
        }
    }
}