package com.example.gardeningservices.network.cart

import com.example.gardeningservices.model.Cart
import com.example.gardeningservices.model.CartDetail
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CartApi {

    @POST("getCart.php")
    @FormUrlEncoded
    suspend fun getCart(
        @Field("idUser") id: Int): Cart

    @POST("getCartDetail.php")
    @FormUrlEncoded
    suspend fun getCartDetail(
        @Field("idCart") id: Int): List<CartDetail>
}