package com.example.gardeningservices.network

import com.example.gardeningservices.network.category.CategoryApi
import com.example.gardeningservices.network.user.UserApi

class ApiUtils {
    companion object {
        val IP  = "192.168.0.95"
        private val URL = "http://"+ IP +":8080/serverTest/"

        fun getCategoryApi(): CategoryApi {
            return  Retrofit.getClient(URL).create(CategoryApi::class.java)
        }

        fun createLoginApi(): UserApi {
            return  Retrofit.getClient(URL).create(UserApi::class.java)
        }
    }
}