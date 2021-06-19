package com.example.gardeningservices.network.user

import androidx.lifecycle.MutableLiveData
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.network.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserResponse {

    private val loginApi = ApiUtils.createLoginApi()

    suspend fun login(username: String, password: String) = loginApi.dologin(username, password)

    suspend fun getIdUser(username: String, password: String) = loginApi.getIdByUser(username, password)
}