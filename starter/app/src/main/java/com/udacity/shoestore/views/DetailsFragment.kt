package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding

/**
 * Shoe Store [Fragment] to enter shoe detail and add a shoe to the Shoe Store listings.
 *
 * @author Gil Cunningham
 */
class DetailsFragment : BaseFragment() {
    override val nextScreen: Int = View.GONE

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<FragmentDetailsBinding>(
        inflater, R.layout.fragment_details, container, false
    ).apply {
        viewModel = mainViewModel
        lifecycleOwner = this@DetailsFragment
    }.root

    override fun navigateToNext() {
        findNavController().navigateUp()
    }

}