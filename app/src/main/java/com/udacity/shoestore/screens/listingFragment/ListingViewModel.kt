package com.udacity.shoestore.screens.listingFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ListingViewModel :ViewModel() {
    private var itemsList :MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())
    var shoe = Shoe()

    fun addItem() {
        itemsList.value?.add(shoe)
        shoe = Shoe()
    }
    fun getList():MutableLiveData<MutableList<Shoe>>{
        return itemsList
    }
}