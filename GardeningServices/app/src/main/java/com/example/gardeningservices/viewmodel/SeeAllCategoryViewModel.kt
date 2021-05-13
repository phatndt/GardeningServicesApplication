package com.example.gardeningservices.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.adapter.CategoryAdapter
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.network.ApiUtils
import com.example.gardeningservices.network.category.CategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeeAllCategoryViewModel(private  val context: Context): ViewModel() {
    private lateinit var listCategory: List<Category>

    fun getListCategory(): List<Category> {
        return  listCategory
    }
    private  fun setListCategory(list: List<Category>) {
        listCategory = list
    }
    private fun getCategory() {

        var categoryAdapter: CategoryAdapter

        var listCategoryItem: List<Category>

        val categoryApi = ApiUtils.getCategoryApi()

        categoryApi.getCategoryHome().enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                response.body()!!.let { setListCategory(it) }
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable?) {
                Toast.makeText(context,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
            }
        })
    }
}