package com.example.gardeningservices.model

import com.google.gson.annotations.SerializedName

class Cart (
    @SerializedName("idCart")
    val idCart: String,
    @SerializedName("idProduct")
    val idProduct: String,
    @SerializedName("quantity")
    val quantity: String
    )