package com.example.gardeningservices

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.network.ApiUtils
import com.example.gardeningservices.network.ServerRetrofit
import com.example.gardeningservices.network.user.UserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private  lateinit var tv_username: TextView
    private  lateinit var tv_password: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val tv_register: TextView = findViewById(R.id.tv_register)
        tv_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java);
            startActivity(intent)
        }

        val button_sign_in: Button = findViewById(R.id.button_sign_in)
        button_sign_in.setOnClickListener {
            login()
        }
        val edt_email: EditText = findViewById(R.id.edt_email)

        tv_username = findViewById(R.id.edt_email)
        tv_password = findViewById(R.id.edt_password)
    }
    private fun login() {

        val loginMail = tv_username.text.toString().trim()
        val loginPassword = tv_password.text.toString().trim()

        if (loginMail.isNotEmpty() && loginPassword.isNotEmpty()) {

            var userApi = ApiUtils.createLoginApi()

            userApi.login(loginMail,loginPassword).enqueue(object: Callback<CRUDresponse>{
                override fun onFailure(call: Call<CRUDresponse>, t: Throwable) {
                    Toast.makeText(this@SignInActivity, t.toString(),Toast.LENGTH_LONG).show()
                }
                override fun onResponse(call: Call<CRUDresponse>, response: Response<CRUDresponse>) {
                    if (response.body()!!.success == 2)
                        Toast.makeText(this@SignInActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
                    if (response.body()!!.success == 1) {
                        startActivity(Intent( this@SignInActivity,MainActivity::class.java)
                        )
                    }
                }

            })
        }
        else {
            Toast.makeText(this@SignInActivity,"Please enter full information",Toast.LENGTH_LONG).show()
        }
    }
}

    
