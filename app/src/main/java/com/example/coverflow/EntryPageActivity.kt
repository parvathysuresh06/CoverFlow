package com.example.coverflow

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import java.util.Locale

class EntryPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_page)
        val cardBtn =findViewById<Button>(R.id.card)
        val labelledSpinner =findViewById<LabelledSpinner>(R.id.spnLang)

        val languageList = listOf("English", "Spanish", "French") // Your list of values for the spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languageList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        labelledSpinner.setAdapter(adapter)

        labelledSpinner.setOnItemSelectedListener(object : LabelledSpinner.OnItemSelectedListener {
            override fun onItemSelected(item: String, position: Int) {
                val selectedLanguage = labelledSpinner.getSelectedItem()
                // Do something with the selected value, e.g., store it in SharedPreferences, pass it to the next activity, etc.
                val configuration = Configuration()
                configuration.setLocale(Locale(selectedLanguage))
                resources.updateConfiguration(configuration, resources.displayMetrics)

//                val intent = Intent(this@EntryPageActivity, MainActivity::class.java)
//                startActivity(intent)
            }
        })

        cardBtn.setOnClickListener {
            // Handle the button click here
        }
    }
}


//        cardBtn.setOnClickListener{
//            val configuration = Configuration()
//            configuration.setLocale(Locale(spnLang.getSelectedItem().toString()))
//            resources.updateConfiguration(configuration, resources.displayMetrics)
//
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//
//        }
//    }
//}