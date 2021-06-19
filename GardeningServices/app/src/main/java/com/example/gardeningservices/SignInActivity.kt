package com.example.gardeningservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.network.ApiUtils
import com.example.gardeningservices.utilities.Converter
import com.example.gardeningservices.viewmodel.CategoryViewModel
import com.example.gardeningservices.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_sign_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private  val userViewModel by lazy {
        return@lazy ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        tv_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java);
            startActivity(intent)
        }

        button_sign_in.setOnClickListener {
            login()
            startActivity(Intent(this@SignInActivity,MainActivity::class.java))
            this@SignInActivity.finish()
        }
    }
    private fun login() {

        val loginMail = edt_email.text.toString().trim()
        val loginPassword = edt_password.text.toString().trim()

        if (loginMail.isNotEmpty() && loginPassword.isNotEmpty()) {

            val convertPass =Converter(loginPassword).sha256()

            userViewModel.login(loginMail, convertPass)
            userViewModel.crudResponseLogin.observe(this, Observer {
                if (it.success == 2)
                    Toast.makeText(this@SignInActivity, it.message, Toast.LENGTH_SHORT).show()
                if (it.success == 1) {
                    startActivity(Intent(this@SignInActivity,MainActivity::class.java))
                    this@SignInActivity.finish()
                }
            })
        }
        else {
            Toast.makeText(this@SignInActivity,"Please enter full information",Toast.LENGTH_LONG).show()
        }
    }
}

    
