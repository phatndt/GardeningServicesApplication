package com.example.gardeningservices.model

import com.google.gson.annotations.SerializedName

class Users (
    @SerializedName("id")
    val id: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("sex")
    val sex: String,
    @SerializedName("telephone")
    val telephone: String,
    @SerializedName("email")
    val email: String
)