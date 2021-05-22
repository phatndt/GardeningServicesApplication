package com.example.gardeningservices.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.gardeningservices.R
import kotlinx.android.synthetic.*
import com.example.gardeningservices.adapter.ServicesAdapter
import com.example.gardeningservices.model.Services
import com.example.gardeningservices.network.ServerRetrofit
import com.example.gardeningservices.network.services.ServicesApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gardeningservices.adapter.CategoryAdapter
import com.example.gardeningservices.viewmodel.ServicesViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeeAllServicesActivity : AppCompatActivity() {
    private lateinit var recycler_view : RecyclerView

    private  val servicesViewModel by lazy {
        return@lazy ViewModelProviders.of(this).get(ServicesViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all_services)
        recycler_view =findViewById(R.id.rcV_services)
        recycler_view.setHasFixedSize(true);
        recycler_view.layoutManager = GridLayoutManager(this,3, GridLayoutManager.VERTICAL, false )

        servicesViewModel.CallAllServicesApi()
        observeResponseData()

        val imageback: ImageView = findViewById(R.id.tv_back_service)
        imageback.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun observeResponseData() {
        servicesViewModel.listServices.observe(this, Observer {
            setUpServicesHome(it)
        })
    }

    private fun setUpServicesHome(list: List<Services>) {
        val servicesAdapter = ServicesAdapter(this@SeeAllServicesActivity, list)
        recycler_view.adapter = servicesAdapter

    }
}