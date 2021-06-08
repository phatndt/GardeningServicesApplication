package com.example.gardeningservices.model

import com.google.gson.annotations.SerializedName

class Products(
    @SerializedName("id")
    val id: Int,
    @SerializedName("idCategory")
    val idCategory: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("discount")
    val discount: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("note")
    val note: String

)