package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import kotlinx.android.parcel.Parcelize

@Parcelize
class Shoe :Parcelable{
    var name:String? = null
    var size:String? = null
    var company:String? = null
    var description:String? = null
    var image:List<String> = mutableListOf()
}