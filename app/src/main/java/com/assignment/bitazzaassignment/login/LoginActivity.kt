package com.assignment.bitazzaassignment.login

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.assignment.bitazzaassignment.R
import com.assignment.bitazzaassignment.landing.LandingActivity
import com.assignment.bitazzaassignment.login.datasource.loginDataSourceModule
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.dsl.module

class LoginActivity : AppCompatActivity() {
    private val viewModel by lifecycleScope.viewModel<LoginViewModel>(this)
    private val progressDialog by lazy {
        ProgressDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bindButtonEvent()
        bindViewModelEvent()
    }

    private fun bindViewModelEvent() {
        viewModel.navigateToLandingEvent.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                startActivity(LandingActivity.getStartIntent(this))
                finish()
            }
        })
        viewModel.toastEvent.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.showProgressEvent.observe(this, Observer {
            it.getContentIfNotHandled()?.let { progressDialog.show() }
        })
        viewModel.hideProgressEvent.observe(this, Observer {
            it.getContentIfNotHandled()?.let { progressDialog.hide() }
        })
    }

    private fun bindButtonEvent() {
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
