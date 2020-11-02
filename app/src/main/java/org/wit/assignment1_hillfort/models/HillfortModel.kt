package org.wit.assignment1_hillfort.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HillfortModel(var id: Long = 0,
                          var name: String = "",
                          var description: String = "",
                          var image: String = "",
                          var lat : Double = 0.0,
                          var lng: Double = 0.0,
                          var zoom: Float = 0f,
                          var email: String = "",
                          var password: String = "",
                          var userlevel: String = "") : Parcelable //user level to indicate basic or admin roles


@Parcelize
data class Location(var lat: Double = 0.0,
                    var lng: Double = 0.0,
                    var zoom: Float = 0f) : Parcelable


@Parcelize
data class User (var email: String = "",
                 var password: String = "",
                 var userlevel: String = ""): Parcelable //user level to indicate basic or admin roles