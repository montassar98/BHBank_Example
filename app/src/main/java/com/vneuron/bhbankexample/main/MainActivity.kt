package com.vneuron.bhbankexample.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.simform.custombottomnavigation.SSCustomBottomNavigation
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.utils.ZoomOutPageTransformer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager2()
        setupBottomNavigationView()
    }

    private fun setupViewPager2() {
        val mAdapter = MainViewPager2Adapter(supportFragmentManager, lifecycle)
        mainViewPager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = mAdapter
            setPageTransformer(ZoomOutPageTransformer())
            registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        when (position){
                            0 -> bottomNavigation.show(ID_HOME)
                            1 -> bottomNavigation.show(ID_TRANSACTIONS)
                            2 -> bottomNavigation.show(ID_STATISTICS)
                            3 -> bottomNavigation.show(ID_ACCOUNT)
                        }
                    }
                }
            )
        }
    }

    private fun setupBottomNavigationView() {
        bottomNavigation.apply {
            add(SSCustomBottomNavigation.Model(ID_HOME,R.drawable.ic_wallet,"Home"))
            add(SSCustomBottomNavigation.Model(ID_TRANSACTIONS,R.drawable.ic_trans,"Transactions"))
            add(SSCustomBottomNavigation.Model(ID_STATISTICS,R.drawable.ic_charts,"Statistics"))
            add(SSCustomBottomNavigation.Model(ID_ACCOUNT,R.drawable.ic_account,"Account"))
            setOnShowListener {
                when (it.id) {
                    ID_HOME -> mainViewPager.currentItem = 0
                    ID_TRANSACTIONS -> mainViewPager.currentItem = 1
                    ID_STATISTICS -> mainViewPager.currentItem = 2
                    ID_ACCOUNT -> mainViewPager.currentItem = 3
                    else -> mainViewPager.currentItem = 0
                }

                val bgColor = when (it.id) {
                    ID_HOME -> ContextCompat.getColor(this@MainActivity, R.color.colorAccent)
                    ID_TRANSACTIONS -> ContextCompat.getColor(this@MainActivity, R.color.colorAccent)
                    ID_STATISTICS -> ContextCompat.getColor(this@MainActivity, R.color.colorAccent)
                    ID_ACCOUNT -> ContextCompat.getColor(this@MainActivity, R.color.colorAccent)
                    else -> ContextCompat.getColor(this@MainActivity, R.color.colorPrimary)
                }


            }
            setOnClickMenuListener {
                val name = when (it.id) {
                    ID_HOME -> "HOME"
                    ID_TRANSACTIONS -> "TRANSACTIONS"
                    ID_STATISTICS -> "STATISTICS"
                    ID_ACCOUNT -> "ACCOUNT"
                    else -> ""
                }
            }

            setOnReselectListener {
                Toast.makeText(context, "item ${it.id} is reselected.", Toast.LENGTH_LONG).show()
            }
        }
        bottomNavigation.show(0, true)
    }



    fun onFundTransferClicked(view: View) {}
    fun onLoansClicked(view: View) {}
    fun onDepositClicked(view: View) {}
    fun onATMLocationsClicked(view: View) {}
    fun onAccountStatementClicked(view: View) {}
    fun onOtherServicesClicked(view: View) {}

    companion object{
        private const val ID_HOME = 0
        private const val ID_TRANSACTIONS = 1
        private const val ID_STATISTICS = 2
        private const val ID_ACCOUNT = 3
    }
}