package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var option :  Spinner
    lateinit var result : TextView

    var text = "Please select an option"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        option = findViewById(R.id.spLng) as Spinner
        result = findViewById(R.id.result) as TextView

        val options = arrayOf("Java", "JS", "Python")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        option.adapter = adapter

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                text = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                result.text = "Please select an Option"
            }

        }

    }

    fun onTapOk(view: View) {
        result.text = text
    }
    fun onTapClose(view: View) {
        result.text = "Please select an Option"
    }


}