package com.example.gardeningservices.network.category

import com.example.gardeningservices.model.SpecialPackage
import retrofit2.Call
import retrofit2.http.GET

interface SpecialPackageApi {
    @GET("getAllSpecialPackage.php")
    fun getAllSpecialPackage(): Call<List<SpecialPackage>>

    @GET("getSpecialPackageHome.php")
    fun getSpecialPackageHome(): Call<List<SpecialPackage>>
}