package com.example.gardeningservices.network.category

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.network.ApiUtils
import com.example.gardeningservices.network.ServerRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRepository {

    private val categoryApi = ApiUtils.getCategoryApi()

    fun getListCategoryApi(liveData: MutableLiveData<List<Category>>) {
        // Your Api Call with response callback
        categoryApi.getAllCategory().enqueue(object: Callback<List<Category>>{
            override fun onFailure(call: Call<List<Category>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                liveData.value = response.body()
            }
        })
    }
}