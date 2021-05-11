package com.example.gardeningservices.utilities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

public class Converter(private val base64String: String) {
    public fun DecodeToImage(): Bitmap {
        val imageBytes = Base64.decode(base64String, android.util.Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }
}