package com.example.gardeningservices.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.gardeningservices.R
import com.example.gardeningservices.SignInActivity
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.network.ApiUtils
import com.example.gardeningservices.network.user.UserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileActivity : AppCompatActivity() {
    private  lateinit var name: TextView
    private  lateinit var gender: TextView
    private  lateinit var date: TextView
    private  lateinit var email: TextView
    private  lateinit var phonenumber:TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val change: Button = findViewById(R.id.btn_edit_profile)
        change.setOnClickListener {
            changeProfile()
        }
        name = findViewById(R.id.edit_profile_name)
        email= findViewById(R.id.edt_profile_email)
        gender= findViewById(R.id.edit_profile_sex)
        phonenumber= findViewById(R.id.edt_profile_telephone)
        date= findViewById(R.id.edt_profile_date)

        val back: ImageView = findViewById(R.id.tv_back_edit_profile)
        back.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun changeProfile() {
        val profileFullName = name.text.toString().trim()
        val profileGender = gender.text.toString().trim()
        val profileMail = email.text.toString().trim()
        val profileDate = date.text.toString().trim()
        val profilePhoneNumber = phonenumber.text.toString().trim()
        if (profileFullName.isNotEmpty() && profileGender.isNotEmpty() && profileMail.isNotEmpty() && profileDate.isNotEmpty() && profilePhoneNumber.isNotEmpty())
        {
            val userApi = ApiUtils.createUpdateProfileApi()
                userApi.updateProfile(profileFullName,profileDate,profileGender,profilePhoneNumber,profileMail).enqueue(object : Callback<CRUDresponse> {
                        override fun onResponse(
                            call: Call<CRUDresponse>, response: Response<CRUDresponse>) {
                            if (response.body()!!.success == 2)
                                Toast.makeText(
                                    this@EditProfileActivity,
                                    response.body()!!.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            if (response.body()!!.success == 1) {
                                startActivity(
                                    Intent(this@EditProfileActivity, SignInActivity::class.java)
                                )}
                        }
                        override fun onFailure(call: Call<CRUDresponse>, t: Throwable) {
                            Toast.makeText(this@EditProfileActivity, t.toString(), Toast.LENGTH_LONG).show()
                        }
                })
        }
    }
}





