package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

/**
 * The [Fragment] responsible for performing Shoe Store login.
 *
 * @author Gil Cunningham
 */
class LoginFragment : BaseFragment() {

    override val nextScreen = R.id.action_loginFragment_to_welcomeFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<FragmentLoginBinding>(
        inflater, R.layout.fragment_login, container, false
    ).apply {
        viewModel = mainViewModel
    }.root

}
