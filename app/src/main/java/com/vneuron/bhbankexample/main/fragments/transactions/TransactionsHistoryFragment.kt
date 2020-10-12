package com.vneuron.bhbankexample.main.fragments.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.model.Transaction
import kotlinx.android.synthetic.main.fragment_transactions_history.*

class TransactionsHistoryFragment(): Fragment(),TransactionsHistoryContract.ViewInterface {

    private lateinit var mAdapter : TransHistoryRVAdapter
    private lateinit var presenter: TransactionsHistoryPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater.inflate(R.layout.fragment_transactions_history, container, false)
        initPresenter()


        return view
    }

    private fun initPresenter(){
        presenter = TransactionsHistoryPresenter(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.retrieveData()
    }

    override fun initHistoryRecyclerView(mData: List<Transaction>) {
        mAdapter = TransHistoryRVAdapter(context!!, mData)
        historyRecyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        }
        mAdapter.notifyDataSetChanged()
    }

    override fun displayMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun displayError(error: String) {
        displayMessage(error)
    }
}