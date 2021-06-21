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