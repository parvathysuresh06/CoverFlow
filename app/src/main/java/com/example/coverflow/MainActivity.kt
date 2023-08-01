package com.example.coverflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator


class MainActivity : AppCompatActivity() {

    var strLang = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        strLang = intent.getStringExtra("language").toString()
        val recyclerView: CoverFlow = findViewById(R.id.recyclerView)

        val coverFlow = CoverFlow(this)
        recyclerView.layoutManager = coverFlow.layoutManager

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
        val recyclerIndicator: ScrollingPagerIndicator = findViewById(R.id.indicator)
        recyclerIndicator.attachToRecyclerView(recyclerView)

    }
}