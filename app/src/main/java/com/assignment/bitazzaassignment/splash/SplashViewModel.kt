package com.assignment.bitazzaassignment.splash

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.assignment.bitazzaassignment.core.LiveDataEvent
import com.assignment.bitazzaassignment.core.RxViewModel
import com.assignment.bitazzaassignment.webscoket.WebSocketApi
import com.tinder.scarlet.WebSocket
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class SplashViewModel(private val webSocketApi: WebSocketApi) : RxViewModel() {
    private val _navigateToLoginLiveDataEvent = MutableLiveData<LiveDataEvent<Unit>>()
    val navigateToLoginLiveDataEvent = _navigateToLoginLiveDataEvent
    fun connect() {
        webSocketApi.observeWebSocketEvent()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                onError = { Log.d("WebSocketEvent error", it.toString()) },
                onNext = { webSocketEvent ->
                    if (webSocketEvent is WebSocket.Event.OnConnectionOpened<*>) {
                        _navigateToLoginLiveDataEvent.postValue(LiveDataEvent(Unit))
                    }
                }).addTo(compositeDisposable)
    }
}