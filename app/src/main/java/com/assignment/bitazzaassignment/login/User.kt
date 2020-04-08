package com.assignment.bitazzaassignment.login

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @Json(name = "accountId")
    val accountId: Int = 0, // 0
    @Json(name = "email")
    val email: String = "",
    @Json(name = "emailVerified")
    val emailVerified: Boolean = false, // false
    @Json(name = "omsId")
    val omsId: Int = 0, // 0
    @Json(name = "use2FA")
    val use2FA: Boolean = false, // false
    @Json(name = "userId")
    val userId: Int = 0, // 0
    @Json(name = "userName")
    val userName: String = ""
) : Parcelable