package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeLiveData

class MainViewModel : ViewModel() {
    private val _shoeListings = mutableListOf<Shoe>()
    val instrucionsVisibility = MutableLiveData(View.VISIBLE)
    val onNextScreen = MutableLiveData<Boolean>()
    var shoeDetails = ShoeLiveData()
    val shoeListings : MutableLiveData<List<Shoe>> = MutableLiveData(_shoeListings)
    val fabVisibility = MutableLiveData(View.GONE)

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
        _shoeListings.add(shoeDetails.shoe)
        shoeListings.value = _shoeListings
        shoeDetails = ShoeLiveData()
        onNextScreen()
    }
}