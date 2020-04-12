package com.assignment.bitazzaassignment.webscoket

import io.reactivex.Flowable
import kotlin.reflect.KClass

interface WebSocketService {
    fun <REQUEST, RESPONSE : Any> requestAndObserve(
        functionName: String,
        request: REQUEST,
        clazz: KClass<RESPONSE>
    ): Flowable<RESPONSE>

    fun <REQUEST> sendRequest(functionName: String, request: REQUEST)
    fun <RESPONSE : Any> observeEvent(
        eventName: String,
        clazz: KClass<RESPONSE>
    ): Flowable<RESPONSE>
}

inline fun <REQUEST, reified RESPONSE : Any> WebSocketService.requestAndObserve(
    functionName: String,
    request: REQUEST
): Flowable<RESPONSE> =
    requestAndObserve(functionName, request, RESPONSE::class)

inline fun <reified RESPONSE : Any> WebSocketService.observeEvent(eventName: String) =
    observeEvent(eventName, RESPONSE::class)

