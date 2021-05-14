package com.example.gardeningservices.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CRUDresponse (
        @SerializedName("success")
        @Expose
        val success: Int,
        @SerializedName("message")
        @Expose
        val message:String
)