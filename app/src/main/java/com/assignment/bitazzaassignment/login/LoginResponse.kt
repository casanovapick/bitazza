package com.assignment.bitazzaassignment.login


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("authenticated")
    val authenticated: Boolean = false, // true
    @SerializedName("errormsg")
    val errormsg: String = "",
    @SerializedName("locked")
    val locked: Boolean = false, // false
    @SerializedName("requires2FA")
    val requires2FA: Boolean = false, // false
    @SerializedName("twoFAToken")
    val twoFAToken: String = "",
    @SerializedName("twoFAType")
    val twoFAType: String = "",
    @SerializedName("user")
    val user: User = User()
) {
    data class User(
        @SerializedName("accountId")
        val accountId: Int = 0, // 0
        @SerializedName("email")
        val email: String = "",
        @SerializedName("emailVerified")
        val emailVerified: Boolean = false, // false
        @SerializedName("omsId")
        val omsId: Int = 0, // 0
        @SerializedName("use2FA")
        val use2FA: Boolean = false, // false
        @SerializedName("userId")
        val userId: Int = 0, // 0
        @SerializedName("userName")
        val userName: String = ""
    )
}