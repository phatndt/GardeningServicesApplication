package com.example.gardeningservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val tvSignIn:TextView=findViewById(R.id.tv_sign_in)
        tvSignIn.setOnClickListener {
            val intent=Intent(this,SignInActivity::class.java)
            startActivity(intent);
        }
    }
}