package com.example.gardeningservices.network.address

import com.example.gardeningservices.model.Address
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AddressApi {
    @GET("get_address.php")
    suspend fun getAddress(): List<Address>

    @POST("get_address_by_id.php")
    @FormUrlEncoded
    suspend fun getAddressById(@Field ("idAddress") idAddress: Int): Address
}