package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Woofbtn=findViewById<Button>(R.id.woofbtn)
        Woofbtn.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}