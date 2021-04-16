package com.example.gardeningservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val tvRegister :TextView=findViewById(R.id.tvregister)
        tvRegister.setOnClickListener {
            val intent=Intent(this,Register::class.java);
            startActivity(intent)
        }
        val edMail :EditText=findViewById(R.id.edEmail)
    }
}