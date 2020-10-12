package com.vneuron.bhbankexample.main.fragments.account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vneuron.bhbankexample.R

class DotIndicatorPager2Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_bank_card, parent, false)) {}
    }

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Empty
    }
}