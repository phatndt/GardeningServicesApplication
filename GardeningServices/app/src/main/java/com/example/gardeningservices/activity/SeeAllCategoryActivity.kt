package com.example.gardeningservices.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.R
import com.example.gardeningservices.adapter.CategoryAdapter
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.network.ServerRetrofit
import com.example.gardeningservices.network.category.CategoryApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeeAllCategoryActivity : AppCompatActivity() {
    private lateinit var recycler_view : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_all_category)
        recycler_view = findViewById(R.id.rcV_category)
        recycler_view.setHasFixedSize(true);
        recycler_view.layoutManager = GridLayoutManager(this,3, GridLayoutManager.VERTICAL, false )
        callAPI()
    }
    private fun callAPI() {
        var categoryAdapter: CategoryAdapter

        var listCategoryItem: List<Category>

        var categoryApi: CategoryApi? = null

        val getRetrofit: ServerRetrofit = ServerRetrofit()

        categoryApi= getRetrofit.getClient()!!.create(CategoryApi::class.java)

        val call: Call<List<Category>> = categoryApi!!.getAllCategory()

        call.enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                listCategoryItem = response.body()!!
                categoryAdapter = CategoryAdapter(this@SeeAllCategoryActivity,listCategoryItem )
                recycler_view.adapter = categoryAdapter
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable?) {
                Toast.makeText(this@SeeAllCategoryActivity,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
            }
        })
    }
}