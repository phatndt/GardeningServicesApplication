package com.example.gardeningservices.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gardeningservices.R
import com.example.gardeningservices.adapter.AddressAdapter
import com.example.gardeningservices.adapter.CategoryAdapter
import com.example.gardeningservices.model.Address
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.utilities.Status
import com.example.gardeningservices.viewmodel.AddressViewModel
import com.example.gardeningservices.viewmodel.CartViewModel
import kotlinx.android.synthetic.main.activity_check_out_shipment.*

class CheckOutShipmentActivity : AppCompatActivity() {

    private lateinit var addressViewModel: AddressViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out_shipment)

        this.addressViewModel = ViewModelProvider(this).get(AddressViewModel::class.java)

        tv_back_checkout_shipping.setOnClickListener {
            super.onBackPressed()
        }
        rcV_checkout_address_shipping.layoutManager = GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false)
        observeResponseData()
    }
    private fun observeResponseData() {
        this.addressViewModel.getListAddress().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { idc -> setUpCategoryHome(idc) }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this@CheckOutShipmentActivity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                } }
        })
    }
    private  fun setUpCategoryHome(list: List<Address>) {
        val addressAdapter = AddressAdapter(this@CheckOutShipmentActivity, list)
        rcV_checkout_address_shipping.adapter = addressAdapter
    }
}