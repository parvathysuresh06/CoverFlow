package com.example.coverflow

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator

class CoverFlow @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : RecyclerView(context, attrs) {

    private val scaleTransformer = ScaleTransformer()
    private val snapHelper = PagerSnapHelper()

    override fun setLayoutManager(layout: LayoutManager?) {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        setSnapHelper()
        super.setLayoutManager(layoutManager)
        super.addOnScrollListener(scaleTransformer)
    }

    private fun setSnapHelper() {
        snapHelper.attachToRecyclerView(this)
    }

    fun scrollingIndicator(recyclerIndicator: ScrollingPagerIndicator, recyclerView: CoverFlow) {
        recyclerIndicator.attachToRecyclerView(recyclerView)
    }

    class ScaleTransformer : OnScrollListener() {

        private val mScaleValue = 0.8f
        private val mTranslationValue = 0.3f

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val mid = recyclerView.width / 2.0f
            val minScale = 0.5f // Minimum scale for the side cards
            for (i in 0 until recyclerView.childCount) {
                val child: View = recyclerView.getChildAt(i)
                val childMid = (child.left + child.right) / 2.0f
                val d = mid.coerceAtMost(kotlin.math.abs(mid - childMid))
                val scale = 1.0f - (1.0f - mScaleValue) * d / mid
                val translationX = mTranslationValue * d
                child.scaleX = scale.coerceAtLeast(minScale)
                child.scaleY = scale.coerceAtLeast(minScale)
                child.translationX = if (childMid < mid) translationX else -translationX
            }
        }
    }
}
