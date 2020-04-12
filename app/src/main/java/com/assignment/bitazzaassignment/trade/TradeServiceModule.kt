package com.assignment.bitazzaassignment.trade

import com.assignment.bitazzaassignment.core.ScopedModule

val tradeServiceModule:ScopedModule = {scope ->
    scope.scoped<TradeService>{ TradeServiceImpl(get()) }
}