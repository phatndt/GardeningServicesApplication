package com.example.gardeningservices.network.plantdetail

import androidx.lifecycle.MutableLiveData
import com.example.gardeningservices.model.PlantDetail
import com.example.gardeningservices.network.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlantDetailRepository {
    private val plantDetailApi = ApiUtils.getPlantDetailApi()

    fun getListPackageApi(liveData: MutableLiveData<List<PlantDetail>>) {
        // Your Api Call with response callback
        plantDetailApi.getPlantDetail().enqueue(object: Callback<List<PlantDetail>> {
            override fun onFailure(call: Call<List<PlantDetail>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<PlantDetail>>,
                response: Response<List<PlantDetail>>
            ) {
                liveData.value = response.body()
            }
        })
    }
}