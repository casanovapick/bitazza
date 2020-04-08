package com.assignment.bitazzaassignment.webscoket

import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable

interface WebSocketApi {
    @Receive
    fun observeWebSocketEvent(): Flowable<WebSocket.Event>

    @Send
    fun send(request: MessageFrame)

    @Receive
    fun observe(): Flowable<MessageFrame>
}