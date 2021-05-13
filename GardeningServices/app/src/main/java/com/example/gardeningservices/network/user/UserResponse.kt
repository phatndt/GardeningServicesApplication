package com.example.gardeningservices.network.user

import androidx.lifecycle.MutableLiveData
import com.example.gardeningservices.model.Users
import com.example.gardeningservices.network.ServerRetrofit

class UserResponse {
    private var instance: UserResponse = UserResponse()
    private var categoryData: MutableLiveData<List<Users>>? = null
    private  val retrofit: ServerRetrofit = ServerRetrofit()
    private  val userApi: UserApi? = null

    fun getInstance():UserResponse {
        if (instance == null) {
            instance = UserResponse()
        }
        return instance
    }
}