package com.vneuron.bhbankexample.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vneuron.bhbankexample.R
import com.yabu.livechart.model.DataPoint
import com.yabu.livechart.model.Dataset
import com.yabu.livechart.view.LiveChart

class StatisticsFragment(): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater.inflate(R.layout.fragment_statistics, container, false)

        val liveChart = view?.findViewById<LiveChart>(R.id.live_chart)
        val dataSet = Dataset(mutableListOf(DataPoint(0f, 1f),
            DataPoint(1f, 3f),
            DataPoint(2f, 6f)
        ))

        liveChart?.setDataset(dataSet)?.drawYBounds()?.drawBaseline()?.drawFill()?.drawDataset()

        return view
    }
}