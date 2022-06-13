package com.apps.jetpackcomposeexamples.example2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.apps.jetpackcomposeexamples.example2.view.RentalCarDetailScreen

class RentalCarDetailFragment : Fragment() {

    private val viewModel: RentalCarViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                viewModel.rentalCarState.value.let { car ->
                    RentalCarDetailScreen()
                }
            }
        }
    }
}