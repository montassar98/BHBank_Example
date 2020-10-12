package com.vneuron.bhbankexample.main.fragments.account

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.model.Option

class OptionsRVAdapter(private val context:Context, private val options: List<Option>)
    : RecyclerView.Adapter<OptionsRVAdapter.OptionsVH>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsVH {
        return OptionsVH(LayoutInflater.from(context).inflate(R.layout.item_account_option, parent,false))
    }

    override fun onBindViewHolder(holder: OptionsVH, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return options.size
    }

    inner class OptionsVH(view:View):RecyclerView.ViewHolder(view){

    }
}