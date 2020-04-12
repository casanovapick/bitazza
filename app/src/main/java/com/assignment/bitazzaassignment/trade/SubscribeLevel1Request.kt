package com.assignment.bitazzaassignment.trade


import com.google.gson.annotations.SerializedName

data class SubscribeLevel1Request(
    @SerializedName("InstrumentId")
    val instrumentId: Int = 0, // 0
    @SerializedName("OMSId")
    val oMSId: Int = 0 // 1
)