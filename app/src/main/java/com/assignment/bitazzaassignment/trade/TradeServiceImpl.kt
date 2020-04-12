package com.assignment.bitazzaassignment.trade

import com.assignment.bitazzaassignment.webscoket.WebSocketService
import com.assignment.bitazzaassignment.webscoket.observeEvent
import io.reactivex.Flowable

class TradeServiceImpl(private val webSocketService: WebSocketService) : TradeService {
    override fun subscribeLevel1(request: SubscribeLevel1Request) {
        webSocketService.sendRequest("SubscribeLevel1", request)
    }

    override fun observeTradeInfo(): Flowable<TradeInfo> {
        return webSocketService.observeEvent("Level1UpdateEvent")
    }
}