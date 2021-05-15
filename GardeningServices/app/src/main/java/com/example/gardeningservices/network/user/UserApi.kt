package com.example.gardeningservices.network.user

import com.example.gardeningservices.model.CRUDresponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded

interface UserApi {
    @FormUrlEncoded
    @POST("post_login.php")
    fun login(
            @Field("username") username: String,
            @Field("password") password: String): Call<CRUDresponse>
    @FormUrlEncoded
    @POST("post_register.php")
    fun signUp(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("email") email: String): Call<CRUDresponse>
}