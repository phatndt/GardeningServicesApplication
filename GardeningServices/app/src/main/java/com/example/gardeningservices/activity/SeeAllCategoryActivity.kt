package com.example.gardeningservices.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.R
import com.example.gardeningservices.adapter.CategoryAdapter
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.network.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeeAllCategoryActivity : AppCompatActivity() {
    private lateinit var recycler_view : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_all_category)
        recycler_view = findViewById(R.id.rcV_category)
        Log.i("GameFragment", "Called ViewModelProviders.of")
        callAPI(recycler_view)
    }
    private  fun setUpCategoryHome(list: MutableList<Category>?) {
        recycler_view.setHasFixedSize(false)
        recycler_view.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        val categoryAdapter = CategoryAdapter(this@SeeAllCategoryActivity, list!!)
        Toast.makeText(this,categoryAdapter.itemCount.toString(),Toast.LENGTH_LONG).show()
        recycler_view.adapter = categoryAdapter
    }
    private fun callAPI(recyclerView: RecyclerView) {
        var categoryAdapter: CategoryAdapter

        var listCategoryItem: List<Category>

        val categoryApi = ApiUtils.getCategoryApi()

        categoryApi.getAllCategory().enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                listCategoryItem = response.body()!!
                categoryAdapter = CategoryAdapter(this@SeeAllCategoryActivity,listCategoryItem )
                recyclerView.adapter = categoryAdapter
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable?) {
                Toast.makeText(this@SeeAllCategoryActivity,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
            }
        })
       }
}