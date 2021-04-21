package com.example.gardeningservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val tv_register :TextView=findViewById(R.id.tv_register)
        tv_register.setOnClickListener {
            val intent=Intent(this, Register::class.java);
            startActivity(intent)
        }
        val button_sign_in:Button=findViewById(R.id.button_sign_in)
        button_sign_in.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"Sign In", Toast.LENGTH_LONG).show()
        }
    }
}