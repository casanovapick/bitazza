package com.assignment.bitazzaassignment.webscoket

import io.reactivex.Flowable
import kotlin.reflect.KClass

interface WebSocketService {
    fun <REQUEST, RESPONSE : Any> requestAndObserve(
        functionName: String,
        request: REQUEST,
        clazz: KClass<RESPONSE>
    ): Flowable<RESPONSE>
}

inline fun <REQUEST, reified RESPONSE : Any> WebSocketService.requestAndObserve(
    functionName: String,
    request: REQUEST
): Flowable<RESPONSE> =
    requestAndObserve(functionName, request, RESPONSE::class)

