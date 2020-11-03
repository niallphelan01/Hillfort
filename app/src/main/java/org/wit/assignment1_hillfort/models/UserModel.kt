package org.wit.assignment1_hillfort.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UsersModel (
    var user_id:Long = 0,
    var email: String = "",
    var password: String = "",
    var userlevel: String = ""): Parcelable //user level to indicate basic or admin roles