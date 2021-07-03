package com.example.gardeningservices.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gardeningservices.R
import com.example.gardeningservices.adapter.AddressAdapter
import com.example.gardeningservices.model.Address
import com.example.gardeningservices.utilities.Status
import com.example.gardeningservices.viewmodel.AddressViewModel
import kotlinx.android.synthetic.main.activity_check_out_shipment.*

class CheckOutShipmentActivity : AppCompatActivity(),AddressAdapter.AddressInterface {

    private lateinit var addressViewModel: AddressViewModel
    private var  id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out_shipment)

        this.addressViewModel = ViewModelProvider(this).get(AddressViewModel::class.java)


        tv_back_checkout_shipping.setOnClickListener {
            super.onBackPressed()
        }
        rcV_checkout_address_shipping.layoutManager = GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false)
        observeResponseData()
        btn_next_check_out.setOnClickListener {
        }
    }
    private fun observeResponseData() {

        val id1 = intent.getIntExtra("idUser",-1)
        this.id = intent.getIntExtra("idUser",-1)

        this.addressViewModel.getListAddress(id1.toString()).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { idc -> setUpCategoryHome(idc as ArrayList<Address>) }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this@CheckOutShipmentActivity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                } }
        })
    }
    private  fun setUpCategoryHome(list: ArrayList<Address>) {
        val addressAdapter = AddressAdapter(this@CheckOutShipmentActivity, list,this)
        rcV_checkout_address_shipping.adapter = addressAdapter
    }

    override fun deleteAddress(id: String) {
        addressViewModel.deleteAddress(id)
    }
}