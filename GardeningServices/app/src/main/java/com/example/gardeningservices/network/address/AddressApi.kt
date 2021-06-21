package com.example.gardeningservices.network.address

import com.example.gardeningservices.model.Address
import retrofit2.Call
import retrofit2.http.GET

interface AddressApi {
    @GET("get_address.php")
    suspend fun getAddress(): List<Address>
}