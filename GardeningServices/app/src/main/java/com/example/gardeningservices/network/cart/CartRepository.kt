package com.example.gardeningservices.network.cart

import androidx.lifecycle.MutableLiveData
import com.example.gardeningservices.model.Cart
import com.example.gardeningservices.network.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartRepository {
    private val categoryApi = ApiUtils.createCartApi()

    fun getListCategoryApi(liveData: MutableLiveData<List<Cart>>) {
        // Your Api Call with response callback
        categoryApi.getCart().enqueue(object: Callback<List<Cart>> {
            override fun onFailure(call: Call<List<Cart>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<Cart>>,
                response: Response<List<Cart>>
            ) {
                liveData.value = response.body()
            }
        })
    }
    fun getCategoryHomeApi(liveData: MutableLiveData<List<Cart>>) {
        // Your Api Call with response callback
        categoryApi.getCartHome().enqueue(object: Callback<List<Cart>> {
            override fun onFailure(call: Call<List<Cart>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<Cart>>,
                response: Response<List<Cart>>
            ) {
                liveData.value = response.body()
            }
        })
    }
}