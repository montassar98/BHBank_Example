package com.vneuron.bhbankexample.main.fragments.account

import com.vneuron.bhbankexample.model.Card

class AccountContract {
    interface ViewInterface {
        fun displayMessage(message:String)
        fun displayError(error:String)
        fun initCardRecyclerView(cards: List<Card>)
    }
    interface PresenterInterface{
        fun retrieveCardsData()
    }
}