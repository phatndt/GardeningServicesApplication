package com.example.gardeningservices.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.gardeningservices.R

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val change: Button = findViewById(R.id.btn_edit_profile)
        change.setOnClickListener {
        }
        val back: ImageView = findViewById(R.id.tv_back_edit_profile)
        back.setOnClickListener {
            super.onBackPressed()
        }
    }
}