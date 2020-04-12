package com.assignment.bitazzaassignment.webscoket

import android.util.Log
import com.google.gson.Gson
import com.tinder.scarlet.Message
import com.tinder.scarlet.WebSocket
import io.reactivex.Flowable
import kotlin.random.Random
import kotlin.reflect.KClass

class WebSocketServiceImpl(private val webSocketApi: WebSocketApi) : WebSocketService {
    init {
        webSocketApi.observeWebSocketEvent()
            .doOnNext(this::logOnReceive)
            .subscribe()
    }

    private fun logOnReceive(event: WebSocket.Event?) {
        if (event is WebSocket.Event.OnMessageReceived) {
            val message = event.message
            if (message is Message.Text) {
                Log.d("OnMessageReceived", message.value)
            }
        }
    }

    override fun <REQUEST, RESPONSE : Any> requestAndObserve(
        functionName: String,
        request: REQUEST,
        clazz: KClass<RESPONSE>
    ): Flowable<RESPONSE> {
        val sequence = Random.nextInt()
        val payload = Gson().toJson(request)
        val messageType = MessageType.REQUEST
        val messageFrame = createMessageFrame(messageType, sequence, functionName, payload)
        sendToWebSocket(messageFrame)
        return webSocketApi.observe().filter {
            it.functionName == functionName && it.sequence == sequence
        }.map {
            Gson().fromJson(it.payload, clazz.java)
        }.take(1)
    }

    private fun sendToWebSocket(messageFrame: MessageFrame) {
        Log.d("Send", Gson().toJson(messageFrame))
        webSocketApi.send(messageFrame)
    }

    private fun createMessageFrame(
        messageType: MessageType,
        sequence: Int,
        functionName: String,
        payload: String
    ): MessageFrame {
        return MessageFrame(
            messageType = messageType,
            sequence = sequence,
            functionName = functionName,
            payload = payload
        )
    }

    override fun <REQUEST> sendRequest(functionName: String, request: REQUEST) {
        val sequence = Random.nextInt()
        val payload = Gson().toJson(request)
        val messageType = MessageType.REQUEST
        val messageFrame = createMessageFrame(messageType, sequence, functionName, payload)
        sendToWebSocket(messageFrame)
    }

    override fun <RESPONSE : Any> observeEvent(
        eventName: String,
        clazz: KClass<RESPONSE>
    ): Flowable<RESPONSE> {
        return webSocketApi.observe().filter {
            it.functionName == eventName && it.functionName == eventName
        }.map {
            Gson().fromJson(it.payload, clazz.java)
        }
    }
}