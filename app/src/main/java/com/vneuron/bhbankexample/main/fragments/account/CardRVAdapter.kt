package com.vneuron.bhbankexample.main.fragments.account

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.model.Card


class CardRVAdapter(private val context: Context, private val data: List<Card>):
    RecyclerView.Adapter<CardRVAdapter.CardViewHolder>() {

    private var DURATION: Long = 500
    private val onAttach = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_bank_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.txtCardNameHolder.text = data[position].cardFullName
        holder.txtCardNumberHolder.text = data[position].cardNumber
        setAnimation(holder.itemView, position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private fun setAnimation(itemView: View, i: Int) {
        var count:Int = i
        if (!onAttach) {
            count = -1
        }
        val isNotFirstItem = i == -1
        count++
        itemView.alpha = 0f
        val animatorSet = AnimatorSet()
        val animator = ObjectAnimator.ofFloat(itemView, "alpha", 0f, 0.5f, 1.0f)
        ObjectAnimator.ofFloat(itemView, "alpha", 0f).start()
        animator.startDelay = if (isNotFirstItem) DURATION / 2 else count * DURATION / 3
        animator.duration = 500
        animatorSet.play(animator)
        animator.start()
    }
    inner class CardViewHolder(v: View):RecyclerView.ViewHolder(v){
        val txtCardNameHolder: TextView = v.findViewById<TextView>(R.id.txtCardNameHolder)
        val txtCardNumberHolder: TextView = v.findViewById<TextView>(R.id.txtCardNumberHolder)
    }
}