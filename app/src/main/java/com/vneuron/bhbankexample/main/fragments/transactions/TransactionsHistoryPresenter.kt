package com.vneuron.bhbankexample.main.fragments.transactions

import com.vneuron.bhbankexample.model.Transaction
import java.util.*

class TransactionsHistoryPresenter(private val view:TransactionsHistoryContract.ViewInterface)
    :TransactionsHistoryContract.PresenterInterface {


    override fun retrieveData() {
        val mList = listOf<Transaction>(
            Transaction(1,"Mobile Recharge", Date(),-10.00),
            Transaction(1,"Mobile Recharge", Date(),-10.00),
            Transaction(1,"Mobile Recharge", Date(),10.00),
            Transaction(1,"Mobile Recharge", Date(),-10.00),
            Transaction(1,"Mobile Recharge", Date(),10.00),
            Transaction(1,"Mobile Recharge", Date(),-10.00),
            Transaction(1,"Mobile Recharge", Date(),60.00),
            Transaction(1,"Mobile Recharge", Date(),50.00),
            Transaction(1,"Mobile Recharge", Date(),-10.00),
            Transaction(1,"Mobile Recharge", Date(),-10.00),
        )
        view.initHistoryRecyclerView(mList)
    }
}