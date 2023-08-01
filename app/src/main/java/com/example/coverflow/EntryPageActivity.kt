package com.example.coverflow

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class EntryPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_page)

        val langBtn = findViewById<Button>(R.id.btn_lang)
        langBtn.setOnClickListener {
            val currentLocale = Locale.getDefault()
            val newLocale = if (currentLocale.language == "ar") {
                Locale("en")
            } else {
                Locale("ar")
            }
            Locale.setDefault(newLocale)
            val configuration = Configuration()
            configuration.setLocale(newLocale)
            resources.updateConfiguration(configuration, resources.displayMetrics)
            recreate()
        }


        val cardBtn =findViewById<Button>(R.id.card)
        cardBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}