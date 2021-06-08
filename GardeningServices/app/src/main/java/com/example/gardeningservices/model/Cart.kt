package com.example.gardeningservices.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Cart (
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("idUser")
    @Expose
    val idUser: Int,
    @SerializedName("total")
    @Expose
    val total: Int,
    @SerializedName("state")
    @Expose
    val state: Int
)