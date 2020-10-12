package com.vneuron.bhbankexample.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vneuron.bhbankexample.main.fragments.account.AccountFragment
import com.vneuron.bhbankexample.main.fragments.HomeFragment
import com.vneuron.bhbankexample.main.fragments.StatisticsFragment
import com.vneuron.bhbankexample.main.fragments.transactions.TransactionsHistoryFragment

class MainViewPager2Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> TransactionsHistoryFragment()
            2 -> StatisticsFragment()
            3 -> AccountFragment()
            else -> HomeFragment()
        }
    }
}