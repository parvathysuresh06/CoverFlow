package com.example.coverflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator
import java.util.*


class MainActivity : AppCompatActivity() {

    var strLang=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        strLang = intent.getStringExtra("language").toString()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val layoutManager = if (strLang == "English"){
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        } else LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)


        recyclerView.layoutManager = layoutManager

        val dataList = listOf(
            CoverData(getString(R.string.accounts), "71.50 MAD"),
            CoverData(getString(R.string.deposit), "53.20 MAD"),
            CoverData(getString(R.string.loans), "92.80 MAD"),
            CoverData(getString(R.string.cards), "72.80 MAD")
        )

        val adapter = CoverFlowAdapter(dataList)
        recyclerView.adapter = adapter

        // Attach ScaleTransformer to RecyclerView
        val scaleTransformer = ScaleTransformer()
        recyclerView.addOnScrollListener(scaleTransformer)
        val recyclerIndicator : ScrollingPagerIndicator = findViewById(R.id.indicator)
        recyclerIndicator.attachToRecyclerView(recyclerView)

    }
}