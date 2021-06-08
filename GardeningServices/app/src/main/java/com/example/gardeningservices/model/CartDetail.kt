package com.example.gardeningservices.model

import com.google.gson.annotations.SerializedName

class CartDetail (
    @SerializedName("id")
    val id: Int,
    @SerializedName("idCart")
    val idCart: Int,
    @SerializedName("idProduct")
    val idProduct: Int,
    @SerializedName("quantity")
    val quantity: Int
)