package com.vneuron.bhbankexample.main.fragments.transactions

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.model.Transaction

class TransHistoryRVAdapter(private val context: Context, private val transData:List<Transaction>)
    :RecyclerView.Adapter<TransHistoryRVAdapter.TransHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransHolder {
        return TransHolder(LayoutInflater.from(context).inflate(R.layout.item_transaction_history,parent,false))
    }

    override fun onBindViewHolder(holder: TransHolder, position: Int) {
        val amount :Double = transData[position].amount
        if (amount>0){
            holder.imgTransState.setImageResource(R.drawable.ic_trans_r)
            holder.txtAmount.setTextColor(ContextCompat.getColor(context,R.color.colorGreen))
            holder.txtCurrencyType.setTextColor(ContextCompat.getColor(context,R.color.colorGreen))
        }else{
            holder.imgTransState.setImageResource(R.drawable.ic_trans_t)
            holder.txtAmount.setTextColor(ContextCompat.getColor(context,R.color.colorAccent))
            holder.txtCurrencyType.setTextColor(ContextCompat.getColor(context,R.color.colorAccent))
        }
        holder.txtTransTitle.text = transData[position].title
        holder.txtAmount.text = transData[position].amount.toString()
    }

    override fun getItemCount(): Int {
        return transData.size
    }

    inner class TransHolder(view: View):RecyclerView.ViewHolder(view){
        val imgTransState: ImageView = view.findViewById(R.id.imgTransState)
        val txtTransTitle: TextView = view.findViewById(R.id.txtTransTitle)
        val txtCurrencyType: TextView = view.findViewById(R.id.txtCurrencyType)
        val txtAmount: TextView = view.findViewById(R.id.txtAmount)
    }
}