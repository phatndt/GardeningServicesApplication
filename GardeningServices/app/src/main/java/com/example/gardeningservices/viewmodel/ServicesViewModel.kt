package com.example.gardeningservices.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gardeningservices.model.Services
import com.example.gardeningservices.network.services.ServicesRepository

class ServicesViewModel: ViewModel() {
    var listServices: MutableLiveData<List<Services>> = MutableLiveData()

    private  var servicesRepository = ServicesRepository()

    fun CallAllServicesApi() {
        servicesRepository.getListServicesApi(listServices)
    }
}