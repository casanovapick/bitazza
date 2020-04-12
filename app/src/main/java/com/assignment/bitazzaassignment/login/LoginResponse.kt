package com.assignment.bitazzaassignment.login


import com.google.gson.annotations.SerializedName


data class LoginResponse(
        @SerializedName("Authenticated")
        val authenticated: Boolean = false, // true
        @SerializedName("EnforceEnable2FA")
        val enforceEnable2FA: Boolean = false, // false
        @SerializedName("errormsg")
        val errormsg: String = "", // null
        @SerializedName("Locked")
        val locked: Boolean = false, // false
        @SerializedName("Requires2FA")
        val requires2FA: Boolean = false, // false
        @SerializedName("SessionToken")
        val sessionToken: String = "", // f950d832-83f5-496e-ba96-ea4a66c9a277
        @SerializedName("TwoFAToken")
        val twoFAToken: String = "", // null
        @SerializedName("TwoFAType")
        val twoFAType: String = "", // null
        @SerializedName("User")
        val user: User = User()
) {
    data class User(
            @SerializedName("AccountId")
            val accountId: Int = 0, // 5047
            @SerializedName("Email")
            val email: String = "", // pick.mail4fb@gmail.com
            @SerializedName("EmailVerified")
            val emailVerified: Boolean = false, // true
            @SerializedName("OMSId")
            val oMSId: Int = 0, // 1
            @SerializedName("Use2FA")
            val use2FA: Boolean = false, // false
            @SerializedName("UserId")
            val userId: Int = 0, // 2651
            @SerializedName("UserName")
            val userName: String = "" // pick.mail4fb@gmail.com
    )
}