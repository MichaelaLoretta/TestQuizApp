package com.example.testquizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CongratsAdapter (private val context: Context,
private val info: DoneFeed

) : BaseAdapter() {
    override fun getCount(): Int {
        return  1
    }

    override fun getItem(p0: Int): Any {
        return p0.toLong()
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, view: View?, viewGroup: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val startRow: View = layoutInflater.inflate(R.layout.congratslist, viewGroup, false)

        startRow.findViewById<TextView>(R.id.tvCorrect).text = "Correct Answers ${info.qCorrectAnswers}"

        return startRow
    }

}

