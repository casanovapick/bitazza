package com.assignment.bitazzaassignment.webscoket

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Flowable
import kotlin.random.Random
import kotlin.reflect.KClass

class WebSocketServiceImpl(private val webSocketApi: WebSocketApi) : WebSocketService {
    override fun <REQUEST, RESPONSE : Any> requestAndObserve(
        functionName: String,
        request: REQUEST,
        clazz: KClass<RESPONSE>
    ): Flowable<RESPONSE> {
        val sequence = Random.nextInt()
        val payload = Gson().toJson(request)
        val messageFrame = MessageFrame(
            messageType = MessageType.REQUEST,
            sequence = sequence,
            functionName = functionName,
            payload = payload
        )
        webSocketApi.send(messageFrame)
        return webSocketApi.observe().filter {
            it.functionName == functionName && it.sequence == sequence
        }.map {
            Gson().fromJson<RESPONSE>(it.payload, clazz.java)
        }
    }
}