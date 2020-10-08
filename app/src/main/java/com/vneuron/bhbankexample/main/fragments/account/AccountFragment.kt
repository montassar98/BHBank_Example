package com.vneuron.bhbankexample.main.fragments.account

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.model.Card
import com.vneuron.bhbankexample.utils.HorizontalSpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment: Fragment(), AccountContract.ViewInterface {

    private lateinit var presenter: AccountPresenter
    private lateinit var mAdapter: CardRVAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater.inflate(R.layout.fragment_account, container, false)
        initPresenter()


        return view
    }
    private fun initPresenter(){
        presenter = AccountPresenter(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.retrieveCardsData()
    }

    override fun initCardRecyclerView(cards: List<Card>) {
        Log.d(TAG, "initCardRecyclerView: ")
        mAdapter = CardRVAdapter(context!!, cards)
        cardsRecyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            addItemDecoration(HorizontalSpaceItemDecoration(700))
        }
        mAdapter.notifyDataSetChanged()

    }

    override fun displayMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun displayError(error: String) {
        displayMessage(message = error)
    }

    companion object{
        private const val TAG = "AccountFragment"
    }
}