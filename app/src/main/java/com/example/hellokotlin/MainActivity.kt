package com.example.hellokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        next = findViewById(R.id.btn_next)
        next.setOnClickListener() {
            val nextIntent = Intent().apply {
                action = "123"
                putExtra("abc", "Job")
                type = "text/plain"
            }
            if (nextIntent.resolveActivity(packageManager) != null) {
                startActivity(nextIntent)
            }
        }
    }
}
