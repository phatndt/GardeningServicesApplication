package com.example.gardeningservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.network.ApiUtils
import com.example.gardeningservices.utilities.Converter
import es.dmoral.toasty.Toasty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private  lateinit var name: TextView
    private  lateinit var email: TextView
    private  lateinit var password: TextView
    private  lateinit var passwordAgain: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val tvSignIn:TextView=findViewById(R.id.tv_sign_in)
        tvSignIn.setOnClickListener {
            val intent=Intent(this,SignInActivity::class.java)
            startActivity(intent);
        }
        name = findViewById(R.id.edt_full_name)
        email= findViewById(R.id.edt_email)
        password = findViewById(R.id.edt_password)
        passwordAgain= findViewById(R.id.edt_password_again)

        val btnSignUp: Button = findViewById(R.id.button_sign_up)
        btnSignUp.setOnClickListener {
            signUp()
        }
    }
    private fun signUp() {

        val signUpUsername = name.text.toString().trim()
        val signUpPassword = password.text.toString().trim()
        val signUpMail = email.text.toString().trim()
        val signUpPasswordAgain = passwordAgain.text.toString().trim()

        if (signUpUsername.isNotEmpty() && signUpMail.isNotEmpty() && signUpPassword.isNotEmpty() && signUpPasswordAgain.isNotEmpty()) {

            if (signUpPassword == signUpPasswordAgain) {
                val userApi = ApiUtils.createLoginApi()

                val convertPass = Converter(signUpPassword).sha256()

                userApi.signUp(signUpUsername,convertPass,signUpMail).enqueue(object: Callback<CRUDresponse> {
                    override fun onFailure(call: Call<CRUDresponse>, t: Throwable) {
                        Toast.makeText(this@RegisterActivity, t.toString(), Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse(call: Call<CRUDresponse>, response: Response<CRUDresponse>) {
                        if (response.body()!!.success == 0)
                            Toasty.info(this@RegisterActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
                        if (response.body()!!.success == 1) {
                            Toasty.success(this@RegisterActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
                            startActivity(Intent( this@RegisterActivity,SignInActivity::class.java)
                            )
                        }
                    }
                })
            }else {
                Toast.makeText(this@RegisterActivity,"Password is not correct", Toast.LENGTH_LONG).show()
            }
        }
        else {
            Toast.makeText(this@RegisterActivity,"Please enter full information", Toast.LENGTH_LONG).show()
        }
    }
}