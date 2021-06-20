package com.example.gardeningservices.network.user

import androidx.lifecycle.MutableLiveData
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.network.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserResponse {

    private val loginApi = ApiUtils.createLoginApi()
    private val profileApi= ApiUtils.createUpdateProfileApi()

    suspend fun login(username: String, password: String) = loginApi.dologin(username, password)
    suspend fun Update_Profile(name: String, date: String,gender:String,telephone:String,email:String)=profileApi.updateProfile(name,date,gender,telephone,email)
    suspend fun getIdUser(username: String, password: String) = loginApi.getIdByUser(username, password)
}