package com.example.gardeningservices.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.gardeningservices.R
import kotlinx.android.synthetic.main.activity_edit_address.*
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditAddressActivity : AppCompatActivity() {
    private  lateinit var nameEdit: TextView
    private  lateinit var phoneEdit: TextView
    private  lateinit var lineEdit: TextView
    private  lateinit var provinceEdit: TextView
    private  lateinit var districtEdit: TextView
    private  lateinit var wardEdit: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_address)
        nameEdit= findViewById(R.id.edt_Full_Name_edit)
        nameEdit.text=intent.getStringExtra("addressName")
        phoneEdit=findViewById(R.id.edt_phoneNumber_address_edit)
        phoneEdit.text=intent.getStringExtra("addressNumber")
        lineEdit=findViewById(R.id.edt_detail_address_edit)
        lineEdit.text=intent.getStringExtra("addressLine")
        provinceEdit= findViewById(R.id.edt_address_province_edit)
        provinceEdit.text=intent.getStringExtra("province")
        districtEdit= findViewById(R.id.edt_district_address_edit)
        districtEdit.text=intent.getStringExtra("district")
        wardEdit = findViewById(R.id.edt_address_ward_edit)
        wardEdit.text= intent.getStringExtra("ward")
        iv_back_checkOut_edit_address.setOnClickListener {
            super.onBackPressed()
        }
    }
}