package com.vneuron.bhbankexample.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.vneuron.bhbankexample.R

class HomeFragment(): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater.inflate(R.layout.fragment_home, container, false)



        return view
    }

    fun onFundTransferClicked(view: View){
        Log.d(TAG, "onFundTransferClicked: ")
        Toast.makeText(context, "on fund clicked", Toast.LENGTH_SHORT).show()
    }


    companion object{
        private const val TAG = "HomeFragment"
    }
}