package com.example.gardeningservices.network.cart

import com.example.gardeningservices.model.CRUDresponse
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

    @POST("post_update_cart_detail.php")
    @FormUrlEncoded
    fun postDeleteCartDetail(
        @Field("idCartDetail") id: Int): Call<CRUDresponse>

    @POST("post_change_quantity_cart.php")
    @FormUrlEncoded
    fun postChangeQuantityItem(
        @Field("idProduct") idProduct: Int,
        @Field("quantity") quantity: Int): Call<CRUDresponse>
}