package com.example.testquizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AnswerAdapter(private val context : Context,
private val answers: ArrayList<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return answers.count()
    }

    override fun getItem(p0: Int): Any {
        return p0.toLong()
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, view: View?, viewGroup: ViewGroup?): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val answerRow: View = layoutInflater.inflate(R.layout.answers, viewGroup, false)
        val answerNumber = p0+1
        answerRow.findViewById<TextView>(R.id.answerNum).text = "${answerNumber}"
        answerRow.findViewById<TextView>(R.id.answerText).text = "${answers[p0]}"


        return answerRow

    }
}