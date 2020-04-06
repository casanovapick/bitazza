package com.assignment.bitazzaassignment.scarlet

import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.messageadapter.moshi.MoshiMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module

private fun provideScarlet(): Scarlet {
    val okHttpClient = OkHttpClient.Builder().build()
    return Scarlet.Builder()
        .webSocketFactory(okHttpClient.newWebSocketFactory("wss://apexapi.bitazza.com/WSGateway"))
        .addMessageAdapterFactory(MoshiMessageAdapter.Factory())
        .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
        .build()
}

val scarletModule = module {
    factory { provideScarlet() }
}