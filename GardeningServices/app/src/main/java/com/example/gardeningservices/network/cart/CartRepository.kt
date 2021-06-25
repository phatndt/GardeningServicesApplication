package com.example.gardeningservices.network.cart

import androidx.lifecycle.MutableLiveData
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.model.Cart
import com.example.gardeningservices.network.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartRepository {

    private  val cartApi = ApiUtils.createCartApi()

    suspend fun getCartByUser(idUser: Int) = cartApi.getCart(idUser)

    suspend fun getCartDetailByCart(idCart: Int) = cartApi.getCartDetail(idCart)

    fun postDeleteCartDetail(idCartDetail: Int) {
        cartApi.postDeleteCartDetail(idCartDetail).enqueue(object : Callback<CRUDresponse>{
            override fun onFailure(call: Call<CRUDresponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<CRUDresponse>, response: Response<CRUDresponse>) {

            }

        })
    }
    fun postChangeQuantityItem(idProduct:Int,quantity: Int) {
        cartApi.postChangeQuantityItem(idProduct,quantity).enqueue(object : Callback<CRUDresponse>{
            override fun onFailure(call: Call<CRUDresponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<CRUDresponse>, response: Response<CRUDresponse>) {

            }

        })
    }
}