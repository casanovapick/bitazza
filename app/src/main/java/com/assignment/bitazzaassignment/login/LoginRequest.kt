package com.assignment.bitazzaassignment.login


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName



@Parcelize
data class LoginRequest(
    @SerializedName("Password")
    val password: String = "",
    @SerializedName("UserName")
    val userName: String = ""
) : Parcelable