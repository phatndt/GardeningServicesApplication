package com.example.gardeningservices.network.products

import androidx.lifecycle.MutableLiveData
import com.example.gardeningservices.model.Products
import com.example.gardeningservices.network.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {
    private val productApi = ApiUtils.createProductApi()

    fun getListPackageApi(liveData: MutableLiveData<List<Products>>) {
        // Your Api Call with response callback
        productApi.getSaleHome().enqueue(object: Callback<List<Products>> {
            override fun onFailure(call: Call<List<Products>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<Products>>,
                response: Response<List<Products>>
            ) {
                liveData.value = response.body()
            }
        })
    }
}