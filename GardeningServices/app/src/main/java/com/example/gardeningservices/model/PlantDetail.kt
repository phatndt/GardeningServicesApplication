package com.example.gardeningservices.model

import com.google.gson.annotations.SerializedName

class PlantDetail (
    @SerializedName("idPlantDetail")
    val idProduct: String,
    @SerializedName("idCategory")
    val idCategory: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("quantity")
    val quantity: String,
    @SerializedName("rating")
    val rating: String

)