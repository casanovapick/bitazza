package com.assignment.bitazzaassignment.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.assignment.bitazzaassignment.login.LoginActivity
import com.assignment.bitazzaassignment.webscoket.webSocketApiModule
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.dsl.module

class SplashActivity : AppCompatActivity() {
    private val viewModel by lifecycleScope.viewModel<SplashViewModel>(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.connect()
        viewModel.navigateToLoginLiveDataEvent.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                startActivity(LoginActivity.getStartIntent(this))
                finish()
            }
        })
    }
}

val splashModule = module {
    scope<SplashActivity> {
        viewModel<SplashViewModel>()
    }
}