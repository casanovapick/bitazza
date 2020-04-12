package com.assignment.bitazzaassignment.home

import androidx.lifecycle.LiveDataReactiveStreams
import com.assignment.bitazzaassignment.core.RxViewModel
import com.assignment.bitazzaassignment.login.datasource.LoginDataSource
import com.assignment.bitazzaassignment.trade.SubscribeLevel1Request
import com.assignment.bitazzaassignment.trade.TradeService

class HomeViewModel(
    private val tradeService: TradeService,private val loginDataSource: LoginDataSource
) : RxViewModel() {
    val tradeInfoLiveData =  LiveDataReactiveStreams.fromPublisher(tradeService.observeTradeInfo())
    fun subscribeTrade() {
        tradeService.subscribeLevel1(SubscribeLevel1Request(oMSId = 1, instrumentId = 1))
    }

    fun logout() {
        loginDataSource.logout()
    }
}