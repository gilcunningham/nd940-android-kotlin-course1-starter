package com.udacity.shoestore.views

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel

/**
 * Base fragment to handle next screen navigation.
 *
 * @author Gil Cunningham
 */
abstract class BaseFragment : Fragment() {

    protected val mainViewModel : MainViewModel by activityViewModels()
    @get:IdRes
    protected abstract val nextScreen: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    @CallSuper
    open protected fun setupViewModel() {
        mainViewModel.onNextScreen.observe(this) { navigateToNext ->
            println("*** navigate to next - $navigateToNext")
            if (navigateToNext) {
                mainViewModel.clearNavigation()
                navigateToNext()
            }
        }
    }

    open fun navigateToNext() {
        findNavController().navigate(nextScreen)
    }
}