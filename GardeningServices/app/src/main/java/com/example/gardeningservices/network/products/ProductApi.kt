package com.example.gardeningservices.network.products

import com.example.gardeningservices.model.Products
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductApi {
    @FormUrlEncoded
    @POST("getProduct.php")
    fun getProduct(
        @Field("id") id: String): Call<List<Products>>
    @GET("getProductSaleHome.php")
    fun getSaleHome(): Call<List<Products>>
}
