package com.assignment.bitazzaassignment.webscoket

import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

private fun provideScarlet(): Scarlet {
    val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor())
        .build()
    val url = "wss://apexapi.bitazza.com/WSGateway/"

    return Scarlet.Builder()
        .webSocketFactory(okHttpClient.newWebSocketFactory(url))
        .addMessageAdapterFactory(GsonMessageAdapter.Factory())
        .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
        .build()
}

val webSocketApiModule = module {
    single<WebSocketApi> { provideScarlet().create() }
    single<WebSocketService> { WebSocketServiceImpl(get()) }
}