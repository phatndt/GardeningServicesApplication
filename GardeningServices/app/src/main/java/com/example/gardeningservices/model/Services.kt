package com.example.gardeningservices.model

import com.google.gson.annotations.SerializedName

class Services (
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price:String,
    @SerializedName("image")
    val image: String,
    @SerializedName("stock_in")
    val stock_in:String,
    @SerializedName("rating")
    val rating: String
)