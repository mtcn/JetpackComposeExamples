package com.apps.jetpackcomposeexamples.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.apps.jetpackcomposeexamples.R
import com.apps.jetpackcomposeexamples.main.model.Showcase
import com.apps.jetpackcomposeexamples.main.view.ShowcaseList

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                viewModel.showcaseState.value?.let {
                    ShowcaseList(list = it, onClick = { showCase ->
                        when (showCase) {
                            Showcase.EVENT_APP -> {
                                findNavController().navigate(R.id.action_mainFragment_to_eventMainFragment)
                            }
                            Showcase.RENTAL_CAR_APP -> {}
                            Showcase.TRAVEL_APP -> {}
                            Showcase.DEFAULT -> {}
                        }
                    })
                }
            }
        }
    }
}