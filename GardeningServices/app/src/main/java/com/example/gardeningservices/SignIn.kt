package com.example.gardeningservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*
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
        btSignIn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"Sign In", Toast.LENGTH_LONG).show()
        }
    }
}