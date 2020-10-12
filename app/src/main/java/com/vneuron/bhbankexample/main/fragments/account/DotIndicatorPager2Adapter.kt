package com.vneuron.bhbankexample.main.fragments.account

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.model.Card

class DotIndicatorPager2Adapter(private val context: Context, private val data:List<Card>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_bank_card, parent, false)) {}
    }

    override fun getItemCount() = 8

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Empty
    }
}