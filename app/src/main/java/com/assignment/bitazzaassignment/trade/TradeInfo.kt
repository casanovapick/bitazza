package com.assignment.bitazzaassignment.trade


import com.google.gson.annotations.SerializedName

data class TradeInfo(
    @SerializedName("BestBid")
    val bestBid: Double? = null, // 6423.57
    @SerializedName("BestOffer")
    val bestOffer: Double? = null, // 6436.53
    @SerializedName("CurrentDayNumTrades")
    val currentDayNumTrades: Int? = null, // 8529
    @SerializedName("CurrentDayPxChange")
    val currentDayPxChange: Double? = null, // 173.93
    @SerializedName("CurrentDayVolume")
    val currentDayVolume: Double? = null, // 3516.31668185
    @SerializedName("InstrumentId")
    val instrumentId: Int? = null, // 1
    @SerializedName("LastTradeTime")
    val lastTradeTime: Long? = null, // 1534862990343
    @SerializedName("LastTradedPx")
    val lastTradedPx: Double? = null, // 6423.57
    @SerializedName("LastTradedQty")
    val lastTradedQty: Double? = null, // 0.96183964
    @SerializedName("OMSId")
    val oMSId: Int? = null, // 1
    @SerializedName("Rolling24HrPxChange")
    val rolling24HrPxChange: Double? = null, // -0.4165607307408487
    @SerializedName("Rolling24HrVolume")
    val rolling24HrVolume: Double? = null, // 4319.63870783
    @SerializedName("Rolling24NumTrades")
    val rolling24NumTrades: Int? = null, // 10585
    @SerializedName("SessionClose")
    val sessionClose: Double? = null, // 6249.64
    @SerializedName("SessionHigh")
    val sessionHigh: Double? = null, // 11111
    @SerializedName("SessionLow")
    val sessionLow: Double? = null, // 4433
    @SerializedName("SessionOpen")
    val sessionOpen: Double? = null, // 6249.64
    @SerializedName("TimeStamp")
    val timeStamp: String? = null, // 1534862990358
    @SerializedName("Volume")
    val volume: Double? = null // 0.96183964
)