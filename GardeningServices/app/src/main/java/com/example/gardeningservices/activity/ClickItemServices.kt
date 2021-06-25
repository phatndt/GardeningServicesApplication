package com.example.gardeningservices.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gardeningservices.R
import com.example.gardeningservices.adapter.ServiceDetailAdapter
import com.example.gardeningservices.adapter.ServicesAdapter
import com.example.gardeningservices.databinding.ActivityClickItemServicesBinding
import com.example.gardeningservices.model.Services
import com.example.gardeningservices.viewmodel.ServicesViewModel
import kotlinx.android.synthetic.main.activity_click_item_services.*

class ClickItemServices : AppCompatActivity() {
    private  val servicesViewModel by lazy {
        return@lazy ViewModelProviders.of(this).get(ServicesViewModel::class.java)
    }
    lateinit var binding: ActivityClickItemServicesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_item_services)
        id_tv_service_name_SD.text=intent.getStringExtra("SERVICENAME")
//        id_im_SD.setImageResource(intent.getStringExtra("SERVICEIMAGE").toInt())
        id_ratingBar.numStars=intent.getIntExtra("SERVICERATING",1)
        id_tv_price_SD.text=intent.getStringExtra("SERVICEPRICE")
        id_tc_stock_in_SD.text=intent.getStringExtra("SERVICESTOCKIN")
        val back: ImageView = findViewById(R.id.tv_back_service_detail)
        back.setOnClickListener {
            super.onBackPressed()
        }

    }
}