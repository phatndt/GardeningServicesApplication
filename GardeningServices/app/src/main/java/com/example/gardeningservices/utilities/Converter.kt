package com.example.gardeningservices.utilities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.math.BigInteger
import java.security.MessageDigest

public class Converter(private val base64String: String) {
    public fun DecodeToImage(): Bitmap {
        val imageBytes = Base64.decode(base64String, android.util.Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }
    public fun md5(): String {
        return hashString(base64String, "MD5")
    }

    public fun sha256(): String {
        return hashString(base64String, "SHA-256")
    }

    public fun hashString(input: String, algorithm: String): String {
        return MessageDigest
            .getInstance(algorithm)
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
    }
}