package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

/**
 * The Shoe Store [Fragment] to display a greeting message and navigate to Shoe Store instructions.
 *
 * @author Gil Cunningham
 */
class WelcomeFragment : BaseFragment() {

    @get:IdRes
    override val nextScreen: Int = R.id.action_welcomeFragment_to_instructionsFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<FragmentWelcomeBinding>(
        inflater, R.layout.fragment_welcome, container, false
    ).apply {
        viewModel = mainViewModel
    }.root
}