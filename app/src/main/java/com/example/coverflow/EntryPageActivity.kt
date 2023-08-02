package com.example.coverflow

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale


class EntryPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_page)
        val cardBtn =findViewById<Button>(R.id.card)
        val spnLang =findViewById<LabeledSpinner>(R.id.spnLang)

        val personNames = arrayOf("EN", "AR")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.select_dialog_item, personNames)
        spnLang.setItem(arrayAdapter)

        cardBtn.setOnClickListener{
            val configuration = Configuration()
            configuration.setLocale(Locale(spnLang.toString()))
            resources.updateConfiguration(configuration, resources.displayMetrics)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}