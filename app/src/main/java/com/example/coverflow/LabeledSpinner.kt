package com.example.coverflow

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import com.example.coverflow.R.styleable.labeledTextViewStyle


class LabeledSpinner @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var spnValue: Spinner
    private lateinit var label: TextView
    private lateinit var outHint: TextView

    init {
        init(attrs)
    }


    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.labeled_spinner, this)
        spnValue = findViewById(R.id.spnValue)
        label = findViewById(R.id.labelValue)
        outHint = findViewById(R.id.out_hint)
        val ta = context.obtainStyledAttributes(attrs, labeledTextViewStyle)
        try {
            label.text = ta.getString(R.styleable.labeledTextViewStyle_labelValue)
        } finally {
            ta.recycle()
        }
    }

    fun setItem(arrayAdapter: ArrayAdapter<String>) {
        spnValue.adapter = arrayAdapter
    }
    fun getSelectedItem(): String {
        return spnValue.selectedItem.toString()
    }

    fun setSelectedItem(position: Int) {
        spnValue.setSelection(position)
    }
}