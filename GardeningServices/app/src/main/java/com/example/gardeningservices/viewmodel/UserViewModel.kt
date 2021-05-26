package com.example.gardeningservices.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.network.user.UserResponse

class UserViewModel: ViewModel() {
    var crudResponseLogin: MutableLiveData<CRUDresponse> = MutableLiveData()

    private var userResponse = UserResponse()

    fun login(username: String, password: String) {
        userResponse.getStateLogin(crudResponseLogin,username, password)
    }
}