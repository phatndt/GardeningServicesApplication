package com.example.gardeningservices.network

import com.example.gardeningservices.network.`package`.SpecialPackageApi
import com.example.gardeningservices.network.category.CategoryApi
import com.example.gardeningservices.network.products.ProductApi
import com.example.gardeningservices.network.services.ServicesApi
import com.example.gardeningservices.network.user.UserApi

class ApiUtils {
    companion object {
        val IP = "192.168.1.8"
        private val URL = "http://" + IP + ":8080/serverTest/"

        fun getCategoryApi(): CategoryApi {
            return Retrofit.getClient(URL).create(CategoryApi::class.java)
        }

        fun getPackageApi(): SpecialPackageApi{
            return Retrofit.getClient(URL).create(SpecialPackageApi::class.java)
        }
        fun createLoginApi(): UserApi {
            return Retrofit.getClient(URL).create(UserApi::class.java)
        }

        fun createProductApi(): ProductApi {
            return Retrofit.getClient(URL).create(ProductApi::class.java)
        }

        fun createServicesApi(): ServicesApi {
            return Retrofit.getClient(URL).create(ServicesApi::class.java)
        }
    }
}