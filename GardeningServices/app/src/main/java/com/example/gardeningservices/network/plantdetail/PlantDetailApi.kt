package com.example.gardeningservices.network.plantdetail

import com.example.gardeningservices.model.PlantDetail
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PlantDetailApi {
    @GET("getPlantDetail.php")
    fun getPlantDetail(): Call<List<PlantDetail>>
    @GET("getPlantDetailHome.php")
    fun getPlantDetailHome(): Call<List<PlantDetail>>
}