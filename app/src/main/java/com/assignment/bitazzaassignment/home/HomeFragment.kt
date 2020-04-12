package com.assignment.bitazzaassignment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.assignment.bitazzaassignment.R
import com.assignment.bitazzaassignment.login.LoginActivity
import com.assignment.bitazzaassignment.login.datasource.loginDataSourceModule
import com.assignment.bitazzaassignment.trade.tradeServiceModule
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_trade_info.*
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.dsl.module

class HomeFragment : Fragment() {
    private val viewModel by lifecycleScope.viewModel<HomeViewModel>(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logoutText.setOnClickListener {
            viewModel.logout()
            startActivity(LoginActivity.getStartIntent(requireContext()))
            requireActivity().finish()
        }
        viewModel.tradeInfoLiveData
            .observe(viewLifecycleOwner, Observer { tradeInfo ->
                tradeInfo.lastTradedPx.let { lastTradeText.text = it.toString() }
                tradeInfo.bestOffer.let { bestOfferText.text = it.toString() }
                tradeInfo.currentDayPxChange.let { changePxText.text = it.toString() }
            })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.subscribeTrade()
    }
}

val homeModule = module {
    scope<HomeFragment> {
        tradeServiceModule(this)
        loginDataSourceModule(this)
        viewModel<HomeViewModel>()
    }
}