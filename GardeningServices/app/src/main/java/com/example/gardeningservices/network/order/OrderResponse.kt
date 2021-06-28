package com.example.gardeningservices.network.order

import com.example.gardeningservices.network.ApiUtils

class OrderResponse {
    private  val orderApi = ApiUtils.createOrderApi()

    suspend fun postOrder(idUser: Int,
                          idAddress: Int,
                          date: String,
                          state: String,
                          provisional_money: Int,
                          shipping: Int,
                          total: Int) = orderApi.postOrder(idUser, idAddress, date, state, provisional_money, shipping, total)

    suspend fun postOrderDetail(idOrder: Int,
                                idProduct: Int,
                                quantity: Int) = orderApi.postOrderDetail(idOrder, idProduct, quantity)
}