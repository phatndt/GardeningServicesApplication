package com.example.gardeningservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gardeningservices.activity.SeeAllGoodOfCategoryActivity
import com.example.gardeningservices.model.Users
import com.example.gardeningservices.utilities.Converter
import com.example.gardeningservices.viewmodel.UserViewModel
import com.example.gardeningservices.utilities.Status.SUCCESS
import com.example.gardeningservices.utilities.Status.ERROR
import com.example.gardeningservices.utilities.Status.LOADING
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignInActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var loginMail: String
    private  lateinit var loginPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        tv_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java);
            startActivity(intent)
        }
        userViewModel = ViewModelProvider(this@SignInActivity).get(UserViewModel::class.java)
        //userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        button_sign_in.setOnClickListener {
            login()
        }

    }
    private fun login() {

        loginMail = edt_email.text.toString().trim()
        loginPassword = edt_password.text.toString().trim()

        if (loginMail.isNotEmpty() && loginPassword.isNotEmpty()) {

            val convertPass =Converter(loginPassword).sha256()
            var list: List<Users>? = null

            userViewModel?.login(loginMail,convertPass)?.observe(this, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        SUCCESS -> {
                            list = it?.data
                            resource.data?.let { users -> retrieveList(users) }
                        }
                        ERROR -> {
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        }
                        LOADING -> {
                        }
                    } }
            })
        }
        else {
            Toast.makeText(this@SignInActivity,"Please enter full information",Toast.LENGTH_LONG).show()
        }
    }
    private fun retrieveList(users: List<Users>) {
        if (users.isNotEmpty()) {
            val intent = Intent(this@SignInActivity, MainActivity::class.java)
            intent.putExtra("idUser",users.first().id)
            startActivity(intent)
            this@SignInActivity.finish()
        }
    }
}

    
