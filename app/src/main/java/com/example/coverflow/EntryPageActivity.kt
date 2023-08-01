package com.example.coverflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView

class EntryPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_page)



        val cardBtn =findViewById<Button>(R.id.card)
        val spnLang =findViewById<Spinner>(R.id.spnLang)

        cardBtn.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
                .putExtra("language",spnLang.selectedItem.toString())
            startActivity(intent)
        }
    }
}