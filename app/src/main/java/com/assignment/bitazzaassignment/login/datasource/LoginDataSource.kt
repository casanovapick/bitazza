package com.assignment.bitazzaassignment.login.datasource

import com.assignment.bitazzaassignment.login.LoginRequest
import com.assignment.bitazzaassignment.login.LoginResponse
import io.reactivex.Flowable
import io.reactivex.Observable

interface LoginDataSource {
    fun login(loginRequest: LoginRequest): Flowable<LoginResponse>
}