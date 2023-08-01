package com.example.coverflow

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import java.util.Locale

class EntryPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_page)
        val cardBtn =findViewById<Button>(R.id.card)
        val spnLang =findViewById<Spinner>(R.id.spnLang)

        cardBtn.setOnClickListener{
            val configuration = Configuration()
            configuration.setLocale(Locale(spnLang.selectedItem.toString()))
            resources.updateConfiguration(configuration, resources.displayMetrics)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}