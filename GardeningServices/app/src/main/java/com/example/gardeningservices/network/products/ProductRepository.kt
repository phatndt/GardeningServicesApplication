package com.example.gardeningservices.network.products

import com.example.gardeningservices.network.ApiUtils

class ProductRepository {

    private  val productApi = ApiUtils.createProductApi()

    suspend fun getProductById(idProduct: Int) = productApi.getProductById(idProduct)
}