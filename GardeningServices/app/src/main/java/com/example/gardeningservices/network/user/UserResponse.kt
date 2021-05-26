package com.example.gardeningservices.network.user

import androidx.lifecycle.MutableLiveData
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.network.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserResponse {
    private val loginApi = ApiUtils.createLoginApi()

    fun getStateLogin(liveData: MutableLiveData<CRUDresponse>,username: String, password: String) {
        loginApi.login(username, password).enqueue(object : Callback<CRUDresponse> {
            override fun onFailure(call: Call<CRUDresponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<CRUDresponse>, response: Response<CRUDresponse>) {
                liveData.value == response.body()
            }
        })
    }
}