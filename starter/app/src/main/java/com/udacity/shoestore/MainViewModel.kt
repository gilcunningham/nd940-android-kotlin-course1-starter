package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeLiveData

/**
 * Shoe Store [ViewModel]
 */
class MainViewModel : ViewModel() {

    private val _fabShown = MutableLiveData(false)
    private val _onNextScreen = MutableLiveData<Boolean>()
    private val _shoeListingsData = mutableListOf<Shoe>()
    private val _shoeListings = MutableLiveData(_shoeListingsData)
    val fabShown : LiveData<Boolean> = _fabShown
    val detailsMessageVisibility = MutableLiveData(View.VISIBLE)
    val onNextScreen : LiveData<Boolean> = _onNextScreen
    var shoeDetails = ShoeLiveData()
    val shoeListings : LiveData<MutableList<Shoe>> = _shoeListings

    fun clearNavigation() {
        _onNextScreen.value = false
    }

    fun hideFab() {
        _fabShown.value = false
    }

    fun onEditUpdate() {
        detailsMessageVisibility.value = View.GONE
    }

    fun onFabClick() = onNextScreen()

    fun onNextScreen() {
        _onNextScreen.value = true
    }

    fun onSave() {
        _shoeListingsData.add(shoeDetails.shoe)
        _shoeListings.value = _shoeListingsData
        shoeDetails = ShoeLiveData()
        onNextScreen()
    }

    fun showFab() {
        _fabShown.value = true
    }
}