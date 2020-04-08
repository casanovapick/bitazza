package com.assignment.bitazzaassignment.webscoket


import com.google.gson.annotations.SerializedName


data class MessageFrame(
    @SerializedName("i")
    val sequence: Int = 0,
    @SerializedName("m")
    val messageType: MessageType = MessageType.REQUEST,
    @SerializedName("n")
    val functionName: String = "", // function name
    @SerializedName("o")
    val payload: String
)

enum class MessageType(value: Int) {
    @SerializedName("0")
    REQUEST(0),

    @SerializedName("1")
    REPLY(1),

    @SerializedName("2")
    SUBSCRIBE_TO_EVENT(2),

    @SerializedName("3")
    EVENT(3),

    @SerializedName("4")
    UNSUBSCRIBE_FROM_EVENT(4),

    @SerializedName("5")
    ERROR(5)
}