package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.ShoeLiveData

class MainViewModel : ViewModel() {
    val instrucionsVisibility = MutableLiveData(View.VISIBLE)
    val onNextScreen = MutableLiveData<Boolean>()
    val shoeDetails = ShoeLiveData()

    fun onNextScreen() {
        onNextScreen.value = true
    }

    fun clearNavigation() {
        onNextScreen.value = false
    }

    fun onEditUpdate() {
        instrucionsVisibility.value = View.GONE
    }

    fun onSave() {
        val shoe = shoeDetails.shoe
        println("*** on save:")
        println("*** name : ${shoe.name}")
        println("*** size : ${shoe.size}")
        println("*** co : ${shoe.company}")
        println("*** desc : ${shoe.description}")
    }
}