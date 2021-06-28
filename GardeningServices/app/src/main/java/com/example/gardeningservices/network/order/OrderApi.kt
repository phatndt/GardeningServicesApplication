package com.example.gardeningservices.network.order

import com.example.gardeningservices.model.Cart
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface OrderApi {
    @POST("post_order.php")
    @FormUrlEncoded
    suspend fun postOrder(
        @Field("idUser") idUser: Int,
        @Field("idAddress") idAddress: Int,
        @Field("date") date: String,
        @Field("state") state: String,
        @Field("provisional_money") provisional_money: Int,
        @Field("shipping") shipping: Int,
        @Field("total") total: Int): Int

    @POST("post_order_detail.php")
    @FormUrlEncoded
    suspend fun postOrderDetail(
        @Field("idOrder") idOrder: Int,
        @Field("idProduct") idProduct: Int,
        @Field("quantity") quantity: Int): Boolean
}