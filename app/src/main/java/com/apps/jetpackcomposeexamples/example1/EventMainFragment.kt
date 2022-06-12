package com.apps.jetpackcomposeexamples.example1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.apps.jetpackcomposeexamples.R
import com.apps.jetpackcomposeexamples.example1.view.EventScreen


class EventMainFragment : Fragment() {

    private val viewModel: EventViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                viewModel.eventState.value.let { list ->
                    EventScreen(list) {
                        findNavController().navigate(
                            R.id.action_eventMainFragment_to_eventDetailFragment,
                            bundleOf("eventArg" to it)
                        )
                    }
                }
            }
        }
    }
}