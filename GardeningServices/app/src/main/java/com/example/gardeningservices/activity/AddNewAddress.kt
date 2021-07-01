package com.example.gardeningservices.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gardeningservices.R
import com.example.gardeningservices.model.Address
import com.example.gardeningservices.utilities.Status
import com.example.gardeningservices.viewmodel.AddressViewModel
import kotlinx.android.synthetic.main.activity_add_new_address.*
import kotlinx.android.synthetic.main.activity_check_out_shipment.*

class AddNewAddress : AppCompatActivity() {
    private lateinit var addressViewModel: AddressViewModel
    private var  id: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_address)

        this.addressViewModel = ViewModelProvider(this).get(AddressViewModel::class.java)

        btn_save_address.setOnClickListener {
            createNewAddress()
        }
        iv_back_checkOut_address.setOnClickListener {
            super.onBackPressed()
        }
    }
    private fun createNewAddress(){
        val userFullName = edt_full_name.text.toString().trim()
        val addressProvince = edt_address_province.text.toString().trim()
        val addressDistrict = edt_district_address.text.toString().trim()
        val addressWard = edt_address_ward.text.toString().trim()
        val addressTelephone=edt_phoneNumber_address.text.toString().trim()
        val addressDetail = edt_detail_address.text.toString().trim()
        val id1 = intent.getIntExtra("idUser",-1)
        this.id = intent.getIntExtra("idUser",-1)

        if (userFullName.isNotEmpty() && addressProvince.isNotEmpty() && addressDistrict.isNotEmpty() && addressWard.isNotEmpty() && addressTelephone.isNotEmpty() && addressDetail.isNotEmpty())
        {
            this.addressViewModel.createNewAddress(id1.toString(),
                userFullName,
                addressTelephone,
                addressDetail,
                addressProvince,
                addressDistrict,
                addressWard
                ).observe(this, Observer {
                it?.let { resource ->
                    when(resource.status){
                        Status.SUCCESS -> {
                        }
                        Status.ERROR -> {
                            Toast.makeText(this@AddNewAddress, it.message, Toast.LENGTH_LONG).show()
                        }
                        Status.LOADING -> {
                        }
                    }

                }
            })

        }
    }

}
