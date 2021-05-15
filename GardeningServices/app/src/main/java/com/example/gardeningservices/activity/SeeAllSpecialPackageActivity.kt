package com.example.gardeningservices.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.R
import com.example.gardeningservices.adapter.SpecialPackageAdapter
import com.example.gardeningservices.model.SpecialPackage
import com.example.gardeningservices.network.ServerRetrofit
import com.example.gardeningservices.network.category.SpecialPackageApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeeAllSpecialPackageActivity : AppCompatActivity() {
    private lateinit var recycler_view : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all_specialpackage)
        recycler_view = findViewById(R.id.rcV_specialpackage)
        recycler_view.setHasFixedSize(true);
        recycler_view.layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL, false )
        callAPI(recycler_view)

        val imageback: ImageView = findViewById(R.id.tv_back_package)
        imageback.setOnClickListener {
            super.onBackPressed()
        }
    }
    private fun callAPI(recyclerView: RecyclerView) {
        var specialpackageAdapter: SpecialPackageAdapter

        var listspecialPackageItem: List<SpecialPackage>

        var specialpackageApi: SpecialPackageApi? = null

        val getRetrofit: ServerRetrofit = ServerRetrofit()

        specialpackageApi= getRetrofit.getClient()!!.create(SpecialPackageApi::class.java)

        val call: Call<List<SpecialPackage>> =  specialpackageApi!!.getAllSpecialPackage()

        call.enqueue(object : Callback<List<SpecialPackage>> {
            override fun onResponse(call: Call<List<SpecialPackage>>, response: Response<List<SpecialPackage>>) {
                listspecialPackageItem = response.body()!!
                specialpackageAdapter = SpecialPackageAdapter(this@SeeAllSpecialPackageActivity,listspecialPackageItem )
                recyclerView.adapter = specialpackageAdapter
            }

            override fun onFailure(call: Call<List<SpecialPackage>>, t: Throwable?) {
                Toast.makeText(this@SeeAllSpecialPackageActivity,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
            }
        })
    }
}