package com.assignment.bitazzaassignment.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assignment.bitazzaassignment.core.LiveDataEvent
import com.assignment.bitazzaassignment.core.RxViewModel
import com.assignment.bitazzaassignment.login.datasource.LoginDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class LoginViewModel(private val loginDataSource: LoginDataSource) : RxViewModel() {
    private val _navigateToLandingEvent = MutableLiveData<LiveDataEvent<Unit>>()
    val navigateToLandingEvent: LiveData<LiveDataEvent<Unit>> = _navigateToLandingEvent
    private val _toastEvent = MutableLiveData<LiveDataEvent<String>>()
    val toastEvent: LiveData<LiveDataEvent<String>> = _toastEvent
    private val _showProgressEvent = MutableLiveData<LiveDataEvent<Unit>>()
    val showProgressEvent: LiveData<LiveDataEvent<Unit>> = _showProgressEvent
    private val _hideProgressEvent = MutableLiveData<LiveDataEvent<Unit>>()
    val hideProgressEvent: LiveData<LiveDataEvent<Unit>> = _hideProgressEvent
    fun login(userName: String, password: String) {
        loginDataSource.login(LoginRequest(userName = userName, password = password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { _showProgressEvent.postValue(LiveDataEvent(Unit)) }
                .doFinally { _hideProgressEvent.postValue(LiveDataEvent(Unit)) }
                .subscribeBy(onError = {}, onNext = {
                    if (it.authenticated) {
                        _navigateToLandingEvent.postValue(LiveDataEvent(Unit))
                    } else {
                        _toastEvent.postValue(LiveDataEvent(it.errormsg))
                    }
                }).addTo(compositeDisposable)
    }

}