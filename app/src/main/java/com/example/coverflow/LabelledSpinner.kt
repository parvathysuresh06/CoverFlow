package com.example.coverflow

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.*
import androidx.core.text.HtmlCompat

class LabelledSpinner  @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    lateinit var value: Spinner
    lateinit var label: TextView
//    lateinit var outHint: TextView
//    lateinit var errorLabel: TextView

    init {
        init(attrs)
    }

    @SuppressLint("CustomViewStyleable", "ResourceAsColor")
    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.activity_labelled_spinner, this)
        value = findViewById(R.id.spinnerValue)
        label = findViewById(R.id.labelValue)
    }


    fun setAdapter(adapter: ArrayAdapter<String>) {
        value.adapter = adapter
    }

    fun setOnItemSelectedListener(listener: AdapterView.OnItemSelectedListener) {
        value.onItemSelectedListener = listener
    }


    fun getSelectedItem(): String {
        return value.selectedItem.toString()
    }
//
//    interface OnItemSelectedListener {
//        fun onItemSelected(item: String, position: Int)
//    }
    interface CustomItemSelectedListener {
        fun onItemSelected(item: String, position: Int)
        fun onNothingSelected()
    }

    }





//        errorLabel = findViewById(R.id.error_text_view)
//        outHint = findViewById(R.id.out_hint)
//        val ta = context.obtainStyledAttributes(attrs, R.styleable.labeledTextViewStyle)
//        try {
//            label.text = ta.getString(R.styleable.labeledTextViewStyle_labelValue)
//            ta.getString(R.styleable.labeledTextViewStyle_hint)?.let {
//                value.hint = HtmlCompat.fromHtml("<small> $it </small>", HtmlCompat.FROM_HTML_MODE_LEGACY)
//            }}
//
            /* if (ta.getString(R.styleable.labeledTextViewStyle_editTextBg) != "" || ta.getString(R.styleable.labeledTextViewStyle_editTextBg) != null) {
                 // value.background = Drawable
                 if (ta.getString(R.styleable.labeledTextViewStyle_editTextBg) == "white")
                     value.setBackgroundColor(R.color.white)
             }*/

//         finally {
//            ta.recycle()
//        }


//    fun setHint(hint: String) {
//        value.hint = HtmlCompat.fromHtml("<small> $hint </small>", HtmlCompat.FROM_HTML_MODE_LEGACY)
//    }






//setContentView(R.layout.activity_labelled_spinner)
