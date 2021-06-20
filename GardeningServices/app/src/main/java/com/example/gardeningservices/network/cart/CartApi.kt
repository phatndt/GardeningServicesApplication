package com.example.gardeningservices.network.cart

import com.example.gardeningservices.model.Cart
import retrofit2.Call
import retrofit2.http.GET

public interface CartApi {
    @GET("getCart.php")
    fun getCartDetail(): Call<List<Cart>>

    @GET("getCartHome.php")
    fun getCategoryHome(): Call<List<Cart>>
}