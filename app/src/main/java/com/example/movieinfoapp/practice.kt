package com.example.movieinfoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.movieinfoapp.databinding.ActivityPracticeBinding
import com.google.gson.Gson
import org.json.JSONObject
import java.util.*

class practice : AppCompatActivity() {
    private lateinit var binding:ActivityPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding =  DataBindingUtil.setContentView(this,R.layout.activity_practice)

        Handler(Looper.getMainLooper()).postDelayed({
           startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, 3000)



    }




}


