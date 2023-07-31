package com.example.coverflow

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ScaleTransformer : RecyclerView.OnScrollListener() {

    private val mScaleValue = 0.8f
    private val mTranslationValue = 0.3f
//    private val mSecondCardScale = 1.0f

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