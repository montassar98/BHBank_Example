package com.vneuron.bhbankexample.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.simform.custombottomnavigation.SSCustomBottomNavigation
import com.vneuron.bhbankexample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView() {
        bottomNavigation.apply {
            add(SSCustomBottomNavigation.Model(ID_HOME,R.drawable.ic_wallet,"Home"))
            add(SSCustomBottomNavigation.Model(ID_TRANSACTIONS,R.drawable.ic_trans,"Transactions"))
            add(SSCustomBottomNavigation.Model(ID_STATISTICS,R.drawable.ic_charts,"Statistics"))
            add(SSCustomBottomNavigation.Model(ID_ACCOUNT,R.drawable.ic_account,"Account"))
            setOnShowListener {
                val name = when (it.id) {
                    ID_HOME -> "Home"
                    ID_TRANSACTIONS -> "Transactions"
                    ID_STATISTICS -> "Statistics"
                    ID_ACCOUNT -> "Account"
                    else -> ""
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
        private const val ID_TRANSACTIONS = 2
        private const val ID_STATISTICS = 3
        private const val ID_ACCOUNT = 4
    }
}