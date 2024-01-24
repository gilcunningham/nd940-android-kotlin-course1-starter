package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding

/**
 * The Shoe Store [Fragment] to enter shoe detail and add a shoe to the Shoe Store listings.
 *
 * @author Gil Cunningham
 */
class DetailsFragment : Fragment() {

    protected val mainViewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<FragmentDetailsBinding>(
        inflater, R.layout.fragment_details, container, false
    ).apply {
        viewModel = mainViewModel
    }.root
}