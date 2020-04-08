package com.assignment.bitazzaassignment.login.datasource

import com.assignment.bitazzaassignment.core.ScopedModule

val loginDataSourceModule: ScopedModule = {
    it.scoped<LoginDataSource> { LoginWebSocketDataSource(get()) }
}