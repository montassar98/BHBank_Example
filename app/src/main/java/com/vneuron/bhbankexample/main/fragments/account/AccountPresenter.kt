package com.vneuron.bhbankexample.main.fragments.account

import com.vneuron.bhbankexample.model.Card

class AccountPresenter(private val view:AccountContract.ViewInterface) : AccountContract.PresenterInterface {


    override fun retrieveCardsData() {
        val cards:MutableList<Card> = mutableListOf<Card>()
        cards.add(Card(1,"Selmi Montassar", "**** **** **** 1256", "12/22",245))
        cards.add(Card(1,"Selmi Montassar", "**** **** **** 1256", "12/22",245))
        cards.add(Card(1,"Selmi Montassar", "**** **** **** 1256", "12/22",245))
        view.initCardRecyclerView(cards)
    }
}