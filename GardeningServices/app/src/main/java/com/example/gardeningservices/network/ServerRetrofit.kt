package com.example.gardeningservices.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class ServerRetrofit {
    private val IP  = "192.168.1.178"
    private val URL = "http://"+IP+":8080/serverTest/"

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}