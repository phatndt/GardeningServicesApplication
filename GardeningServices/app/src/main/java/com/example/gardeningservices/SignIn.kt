package com.example.gardeningservices

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val tvRegister :TextView=findViewById(R.id.tv_register)
        tvRegister.setOnClickListener {
            val intent=Intent(this, Register::class.java);
            startActivity(intent)
        }
        val edMail :EditText=findViewById(R.id.edt_email)

    }
}