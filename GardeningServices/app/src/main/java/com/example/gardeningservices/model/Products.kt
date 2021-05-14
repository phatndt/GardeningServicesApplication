package com.example.gardeningservices.model

import com.google.gson.annotations.SerializedName

class Products(
    @SerializedName("idProduct")
    val idProduct: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("discount")
    val discount: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("quantity")
    val quantity: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("note")
    val note: String

)