package com.example.coverflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        val dataList = listOf(
            CoverData("ACCOUNTS", "71.50 MAD"),
            CoverData("DEPOSIT", "53.20 MAD"),
            CoverData("LOANS", "92.80 MAD"),
            CoverData("CARD", "72.80 MAD")
        )

        val adapter = CoverFlowAdapter(dataList)
        recyclerView.adapter = adapter

        // Attach ScaleTransformer to RecyclerView
        val scaleTransformer = ScaleTransformer()
        recyclerView.addOnScrollListener(scaleTransformer)
    }
}