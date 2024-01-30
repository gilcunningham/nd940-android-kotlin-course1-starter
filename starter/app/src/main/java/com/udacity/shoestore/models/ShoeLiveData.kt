package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData

/**
 * Shoe details as [LiveData]
 *
 * @author Gil Cunningham
 */
data class ShoeLiveData(
    private val _shoe: Shoe = Shoe()
) {
    var company = MutableLiveData(_shoe.company)
    val description = MutableLiveData(_shoe.description)
    val name = MutableLiveData(_shoe.name)
    val shoe: Shoe
        get() = _shoe.apply {
                company = this@ShoeLiveData.company.value.toString()
                description = this@ShoeLiveData.description.value.toString()
                name = this@ShoeLiveData.name.value.toString()
                size = this@ShoeLiveData.size.value?.toString()?.toDoubleOrNull() ?: 0.0
            }
    val size = MutableLiveData(if (_shoe.size <= 0) "" else _shoe.size.toString())
}