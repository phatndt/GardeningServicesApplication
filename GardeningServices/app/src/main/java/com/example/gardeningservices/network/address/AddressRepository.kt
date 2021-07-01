package com.example.gardeningservices.network.address

import androidx.lifecycle.MutableLiveData
import com.example.gardeningservices.model.Address
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.network.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressRepository {
    private val addressApi = ApiUtils.createAddressApi()
    suspend fun getListAddress() = addressApi.getAddress()
    suspend fun createNewAddress(idUser:String,address_name:String,address_number:String,address_line:String,province:String,district:String,ward:String)=addressApi.createAddress(idUser,address_name,address_number,address_line,province,district,ward)
}