package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeLiveData

/**
 * Shoe Store [ViewModel] maintains observable list of shoes, provides view visibility and text
 * backing, and handles ui events.
 *
 * @author Gil Cunningham
 */
class MainViewModel : ViewModel() {

    private val _detailsMessageVisibility = MutableLiveData(View.VISIBLE)
    private val _fabShown = MutableLiveData(false)
    private val _onNextScreen = MutableLiveData<Boolean>()
    private val _shoeListingsData = mutableListOf<Shoe>()
    private val _shoeListings = MutableLiveData(_shoeListingsData)
    val detailsMessageVisibility : LiveData<Int> = _detailsMessageVisibility
    val fabShown : LiveData<Boolean> = _fabShown
    val onNextScreen : LiveData<Boolean> = _onNextScreen
    var shoeDetails = ShoeLiveData()
    val shoeListings : LiveData<MutableList<Shoe>> = _shoeListings

    fun onClearNavigation() {
        _onNextScreen.value = false
    }

    fun onHideFab() {
        _fabShown.value = false
    }

    fun onEditUpdate() {
        _detailsMessageVisibility.value = View.GONE
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

    fun onShowFab() {
        _fabShown.value = true
    }
}