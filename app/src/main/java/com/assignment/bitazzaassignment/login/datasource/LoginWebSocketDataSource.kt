package com.assignment.bitazzaassignment.login.datasource

import com.assignment.bitazzaassignment.login.LoginRequest
import com.assignment.bitazzaassignment.login.LoginResponse
import com.assignment.bitazzaassignment.webscoket.WebSocketService
import com.assignment.bitazzaassignment.webscoket.requestAndObserve
import io.reactivex.Flowable

class LoginWebSocketDataSource(private val webSocketService: WebSocketService) : LoginDataSource {
    override fun login(loginRequest: LoginRequest): Flowable<LoginResponse> {
        return webSocketService.requestAndObserve(
            functionName = "AuthenticateUser",
            request = loginRequest
        )
    }

    override fun logout() {
        webSocketService.sendRequest("Logout",Unit)
    }
}