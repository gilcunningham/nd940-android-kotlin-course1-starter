package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val onNextScreen = MutableLiveData<Boolean>()

    fun onNextScreen() {
        println("*** next screen")
        onNextScreen.value = true
    }

    fun clearNavigation() {
        onNextScreen.value = false
    }
}