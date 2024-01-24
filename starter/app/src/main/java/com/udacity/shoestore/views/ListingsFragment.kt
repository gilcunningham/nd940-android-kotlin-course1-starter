package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentListingsBinding

/**
 * The Shoe Store [Fragment] to display Shoe Store Listings.
 *
 * @author Gil Cunningham
 */
class ListingsFragment : BaseFragment() {

    override val nextScreen: Int = R.id.action_listingsFragment_to_detailsFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<FragmentListingsBinding>(
        inflater, R.layout.fragment_listings, container, false
    ).apply {
        viewModel = mainViewModel
    }.root
}