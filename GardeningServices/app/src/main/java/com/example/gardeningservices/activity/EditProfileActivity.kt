package com.example.gardeningservices.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gardeningservices.MainActivity
import com.example.gardeningservices.R
import com.example.gardeningservices.fragment.ProfileFragment
import com.example.gardeningservices.model.Users
import com.example.gardeningservices.utilities.Converter
import com.example.gardeningservices.utilities.Status
import com.example.gardeningservices.viewmodel.UserViewModel
import com.tsongkha.spinnerdatepicker.DateUtils.formatDate
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder
import kotlinx.android.synthetic.main.activity_edit_profile.*
import java.text.SimpleDateFormat
import java.util.*


class EditProfileActivity : AppCompatActivity() {
    private  lateinit var name: TextView
    private  lateinit var gender: TextView
    private  lateinit var date: TextView
    private  lateinit var email: TextView
    private  lateinit var telephone:TextView
    private lateinit var userViewModel: UserViewModel
    private var  id: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val change: Button = findViewById(R.id.btn_edit_profile)
        change.setOnClickListener {
            changeProfile()
        }
        userViewModel = ViewModelProvider(this@EditProfileActivity).get(UserViewModel::class.java)

        name = findViewById(R.id.edit_profile_name)
        name.text=intent.getStringExtra("name")
        email= findViewById(R.id.edt_profile_email)
        email.text=intent.getStringExtra("email")
        gender= findViewById(R.id.auto_tv_gender)
        gender.text=intent.getStringExtra("gender")
        telephone= findViewById(R.id.edt_profile_telephone)
        telephone.text=intent.getStringExtra("telephone")
        date= findViewById(R.id.edt_profile_date)
        date.text= intent.getStringExtra("date")?.let { Converter.convertDate(it) }
        val back: ImageView = findViewById(R.id.tv_back_edit_profile)
        back.setOnClickListener {
            super.onBackPressed()
        }

        val itemGender = resources.getStringArray(R.array.listGender)
        val arrayGenderAdapter = ArrayAdapter<String>(this,R.layout.item_gender,itemGender)
        auto_tv_gender.threshold=0
        auto_tv_gender.setAdapter(arrayGenderAdapter)
        auto_tv_gender.setOnFocusChangeListener( { v, hasFocus -> if(hasFocus) auto_tv_gender.showDropDown()  })

        val calendar : Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        date.setOnClickListener {
//            val  datePicker = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth -> date.setText(" "+dayOfMonth+"-"
//                    +(month+1)+"-"+ year)},day,month,year)
//            datePicker.show()
            openSpinnerBirthdayDialog()
        }
    }
    private fun openSpinnerBirthdayDialog() {
        val calendar = Calendar.getInstance().apply {
            add(Calendar.YEAR, -18)
        }

        DatePickerDialog(this, R.style.SpinnerDatePickerDialog, { _, year, month, dayOfMonth ->
            val s = "$dayOfMonth-$month-$year"
            date.text = s
        },
            calendar[Calendar.YEAR],
            calendar[Calendar.MONTH],
            calendar[Calendar.DAY_OF_MONTH]
        ).apply {
            datePicker.maxDate = Date().time
        }.show()
    }
    private fun changeProfile() {
        val profileFullName = name.text.toString().trim()
        val profileGender = gender.text.toString().trim()
        val profileMail = email.text.toString().trim()
        val profileDate = Converter.convertYMD(date.text.toString().trim())
        val profileTelephone = telephone.text.toString().trim()
        val intent: Intent = intent
        val id1 = intent.getIntExtra("idUser",-1)
        this.id = intent.getIntExtra("idUser",-1)
        if (profileFullName.isNotEmpty() && profileGender.isNotEmpty() && profileMail.isNotEmpty() && profileDate.isNotEmpty() && profileTelephone.isNotEmpty())
        {
            userViewModel.updateProfile(
                id1.toString(),
                profileFullName,
                profileDate,
                profileGender,
                profileTelephone,
                profileMail
            ).observe(this, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
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
}





