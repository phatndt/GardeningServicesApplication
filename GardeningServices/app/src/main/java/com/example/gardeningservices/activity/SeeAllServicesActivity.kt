package com.example.gardeningservices.activity

import android.os.Bundle
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
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.network.category.CategoryApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeeAllServicesActivity : AppCompatActivity() {
    private lateinit var recycler_view : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all_services)
        recycler_view =findViewById(R.id.rcV_services)
        recycler_view.setHasFixedSize(true);
        recycler_view.layoutManager = GridLayoutManager(this,3, GridLayoutManager.VERTICAL, false )
        callAPI()
    }

    private fun callAPI() {
        var servicesAdapter: ServicesAdapter

        var listServicesItem:List<Services>

        var servicesApi: ServicesApi?=null

        val getRetrofit: ServerRetrofit = ServerRetrofit()

        servicesApi = getRetrofit.getClient()!!.create(ServicesApi::class.java)

        val call: Call<List<Services>> = servicesApi!!.getAllServices()

        call.enqueue(object : Callback<List<Services>>
        {
            override fun onResponse(call: Call<List<Services>>, response: Response<List<Services>>) {
                listServicesItem= response.body()!!
                servicesAdapter = ServicesAdapter(this@SeeAllServicesActivity, listServicesItem)
                recycler_view.adapter = servicesAdapter
            }
            override fun onFailure(call: Call<List<Services>>, t: Throwable) {
                Toast.makeText(this@SeeAllServicesActivity,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
            }
        })
    }
}