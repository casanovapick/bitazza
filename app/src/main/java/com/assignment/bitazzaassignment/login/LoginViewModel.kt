package com.assignment.bitazzaassignment.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.assignment.bitazzaassignment.login.datasource.LoginDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class LoginViewModel(private val loginDataSource: LoginDataSource) : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun login(userName: String, password: String) {
        loginDataSource.login(LoginRequest(userName, password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onError = {}, onNext = {
                Log.d("on login",it.toString())
                if (it.authenticated) {

                } else {

                }
            }).addTo(compositeDisposable)
    }

}