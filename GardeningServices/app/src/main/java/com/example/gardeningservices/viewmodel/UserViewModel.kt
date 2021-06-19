package com.example.gardeningservices.viewmodel

import androidx.lifecycle.*
import com.example.gardeningservices.model.CRUDresponse
import com.example.gardeningservices.network.user.UserResponse
import com.example.gardeningservices.utilities.Resource
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

class UserViewModel: ViewModel() {

    private var userResponse: UserResponse = UserResponse()

    fun login(username: String, password: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = userResponse.login(username,password)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getIdUser(username: String, password: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = userResponse.getIdUser(username,password)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}