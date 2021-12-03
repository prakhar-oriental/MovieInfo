package com.example.movieinfoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject


class tyu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tyu)

        val intent = intent

        if (intent != null) {
            val json = intent.getStringExtra("json")
            val jsonObj = JSONObject(json)
        }

    }
}