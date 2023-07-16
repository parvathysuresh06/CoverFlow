package com.example.coverflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val dataList = listOf(
            CoverData("Item 1", "71.50 MAD"),
            CoverData("Item 2", "53.20 MAD"),
            CoverData("Item 3", "92.80 MAD"),
            CoverData("Item 3", "92.80 MAD")

        )

        val adapter = CoverFlowAdapter(dataList)
        recyclerView.adapter = adapter

        val currentLocale = Locale.getDefault()
        val isArabic = currentLocale.language == "ar"

//        if (isArabic) {
//            recyclerView.layoutDirection = View.LAYOUT_DIRECTION_RTL
//        }

        recyclerView.layoutDirection = View.LAYOUT_DIRECTION_RTL

    }
}