package com.vneuron.bhbankexample.main.fragments.transactions

import com.vneuron.bhbankexample.model.Transaction

class TransactionsHistoryContract {
    interface ViewInterface{
        fun displayMessage(message:String)
        fun displayError(error:String)
        fun initHistoryRecyclerView(mData: List<Transaction>)
    }
    interface PresenterInterface{
        fun retrieveData()
    }
}