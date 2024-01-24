package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

/**
 * The Shoe Store [Fragment] to display instructions and navigate to Shoe Store listings.
 *
 * @author Gil Cunningham
 */
class InstructionsFragment : BaseFragment() {

    @get:IdRes
    override val nextScreen= R.id.action_instructionsFragment_to_listingsFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<FragmentInstructionsBinding>(
        inflater, R.layout.fragment_instructions, container, false
    ).apply {
        viewModel = mainViewModel
    }.root
}