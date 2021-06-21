package com.example.gardeningservices.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gardeningservices.MainActivity
import com.example.gardeningservices.R
import com.example.gardeningservices.SignInActivity
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.model.Users
import com.example.gardeningservices.network.ApiUtils
import com.example.gardeningservices.network.user.UserApi
import com.example.gardeningservices.utilities.Status
import com.example.gardeningservices.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileActivity : AppCompatActivity() {
    private  lateinit var name: TextView
    private  lateinit var gender: TextView
    private  lateinit var date: TextView
    private  lateinit var email: TextView
    private  lateinit var telephone:TextView
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val change: Button = findViewById(R.id.btn_edit_profile)
        change.setOnClickListener {
        }

        userViewModel = ViewModelProvider(this@EditProfileActivity).get(UserViewModel::class.java)



        name = findViewById(R.id.edit_profile_name)
        email= findViewById(R.id.edt_profile_email)
        gender= findViewById(R.id.edit_profile_sex)
        telephone= findViewById(R.id.edt_profile_telephone)
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
        val profileTelephone = telephone.text.toString().trim()

        if (profileFullName.isNotEmpty() && profileGender.isNotEmpty() && profileMail.isNotEmpty() && profileDate.isNotEmpty() && profileTelephone.isNotEmpty())
        {
            var list: List<Users>? = null
            userViewModel?.Update_Profile(profileFullName,profileDate,profileGender,profileTelephone,profileMail)?.observe(this, Observer {
                    it?.let { resource ->
                        when (resource.status) {
                            Status.SUCCESS -> {
                                list = it?.data
                                resource.data?.let { users -> retrieveList(users) }
                            }
                            Status.ERROR -> {
                                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                            }
                            Status.LOADING -> {
                            }
                        }
                    }
                })
        }
    }
    private fun retrieveList(users: List<Users>) {
        if (users.isNotEmpty()) {
            val intent = Intent(this@EditProfileActivity, MainActivity::class.java)
                intent.getIntExtra("idUser",-1)
                startActivity(intent)
                this@EditProfileActivity.finish()
        }
    }
}

