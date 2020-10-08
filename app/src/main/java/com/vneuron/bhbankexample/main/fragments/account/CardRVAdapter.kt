package com.vneuron.bhbankexample.main.fragments.account

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.model.Card

class CardRVAdapter(private val context:Context,private val data:List<Card>):
    RecyclerView.Adapter<CardRVAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(LayoutInflater.from(context).inflate(R.layout.item_bank_card,parent, false))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.txtCardNameHolder.text = data[position].cardFullName
        holder.txtCardNumberHolder.text = data[position].cardNumber
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class CardViewHolder(v:View):RecyclerView.ViewHolder(v){
        val txtCardNameHolder = v.findViewById<TextView>(R.id.txtCardNameHolder)
        val txtCardNumberHolder = v.findViewById<TextView>(R.id.txtCardNumberHolder)
    }
}