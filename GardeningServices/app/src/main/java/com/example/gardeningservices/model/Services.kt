package com.example.gardeningservices.model

import com.google.gson.annotations.SerializedName

class Services (
    @SerializedName("id")
    val id: String,
    @SerializedName("idServices")
    val idServices:String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price:String,
    @SerializedName("image")
    val image: String,
    @SerializedName("stockIn")
    val stockIn:String,
    @SerializedName("rating")
    val rating: String
)