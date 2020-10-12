package com.vneuron.bhbankexample.main.fragments.account

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.model.Card
import com.vneuron.bhbankexample.utils.DotsIndicatorDecoration
import kotlinx.android.synthetic.main.fragment_account.*
import android.view.View as View


class AccountFragment: Fragment(), AccountContract.ViewInterface, View.OnClickListener {

    private lateinit var presenter: AccountPresenter
    private lateinit var mAdapter: CardRVAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_account, container, false)
        initPresenter()
        /** init listeners */
        view.findViewById<LinearLayout>(R.id.disableCard).setOnClickListener(onDisableCardClicked)
        view.findViewById<LinearLayout>(R.id.viewPin).setOnClickListener(onViewPinClicked)
        view.findViewById<LinearLayout>(R.id.Security).setOnClickListener(onSecurityClicked)
        view.findViewById<LinearLayout>(R.id.limit).setOnClickListener(onLimitClicked)
        view.findViewById<LinearLayout>(R.id.cardSettings).setOnClickListener(onCardSettingsClicked)
        /******************/

            return view
    }

    private val onDisableCardClicked = View.OnClickListener {
        Log.d(TAG, "onDisableCardClicked")
    }
    private val onViewPinClicked = View.OnClickListener {
        Log.d(TAG, "onViewPinClicked")
    }
    private val onSecurityClicked = View.OnClickListener {
        Log.d(TAG, "onSecurityClicked")
    }
    private val onLimitClicked = View.OnClickListener {
        Log.d(TAG, "onLimitClicked")
    }
    private val onCardSettingsClicked = View.OnClickListener {
        Log.d(TAG, "onCardSettingsClicked")
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
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            //addItemDecoration(HorizontalSpaceItemDecoration(700))
            val radius = 10
            val dotsHeight = 20
            val color = ContextCompat.getColor(context, R.color.colorPrimary)
            addItemDecoration(
                DotsIndicatorDecoration(
                    radius,
                    radius * 4,
                    dotsHeight,
                    color,
                    color
                )
            )
            PagerSnapHelper().attachToRecyclerView(this)
        }
        mAdapter.notifyDataSetChanged()


       /* val adapter = DotIndicatorPager2Adapter()
        view_pager2.adapter = adapter
        val zoomOutPageTransformer = ZoomOutPageTransformer()
        viewPager2?.setPageTransformer { page, position ->
            zoomOutPageTransformer.transformPage(page, position)
        }*/


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

    override fun onClick(p0: View?) {
        val id:Int? = p0?.id
        displayMessage("onClick")
        when(id){
            R.id.disableCard -> {
                displayMessage("disable card")
                Log.d(TAG, "onClick: disable card")
            }
            R.id.viewPin  -> displayMessage("view pin")
            R.id.Security  -> displayMessage("security")
            R.id.limit  -> displayMessage("limit")
            R.id.cardSettings  -> displayMessage("card settings")
        }
    }
}