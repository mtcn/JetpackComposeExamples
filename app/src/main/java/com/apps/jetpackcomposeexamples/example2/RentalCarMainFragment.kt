package com.apps.jetpackcomposeexamples.example2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.apps.jetpackcomposeexamples.R
import com.apps.jetpackcomposeexamples.example2.view.RentalCarMainScreen

class RentalCarMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                RentalCarMainScreen {
                    findNavController().navigate(R.id.action_rentalCarMainFragment_to_rentalCarDetailFragment)
                }
            }
        }
    }
}