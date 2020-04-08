package com.assignment.bitazzaassignment.core

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class RxViewModel :ViewModel(){
    protected  val compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}