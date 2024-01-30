package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel

/**
 * Base Shoe Store [Fragment] to handle next screen navigation.
 *
 * @author Gil Cunningham
 */
abstract class BaseFragment : Fragment() {

    protected val mainViewModel : MainViewModel by activityViewModels()
    @get:IdRes
    protected abstract val nextScreen: Int

    protected open fun navigateToNext() {
        findNavController().navigate(nextScreen)
    }

    @CallSuper
    protected open fun observeViewModel() {
        mainViewModel.onNextScreen.observe(this) { navigateToNext ->
            if (navigateToNext) {
                mainViewModel.onClearNavigation()
                navigateToNext()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
    }
}