package com.assignment.bitazzaassignment.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assignment.bitazzaassignment.R
import com.assignment.bitazzaassignment.login.datasource.loginDataSourceModule
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.dsl.module

class LoginActivity : AppCompatActivity() {
    private val viewModel by lifecycleScope.viewModel<LoginViewModel>(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            viewModel.login(username, password)
        }
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}

val loginModule = module {
    scope<LoginActivity> {
        viewModel<LoginViewModel>()
        loginDataSourceModule(this)
    }
}
