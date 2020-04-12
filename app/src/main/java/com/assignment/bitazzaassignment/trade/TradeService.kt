package com.assignment.bitazzaassignment.trade

import io.reactivex.Flowable
import io.reactivex.Observable

interface TradeService {
    fun subscribeLevel1(request: SubscribeLevel1Request)
    fun observeTradeInfo(): Flowable<TradeInfo>
}