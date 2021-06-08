package com.example.gardeningservices.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gardeningservices.model.Cart
import com.example.gardeningservices.network.cart.CartRepository
import com.example.gardeningservices.utilities.Resource
import kotlinx.coroutines.Dispatchers

class CartViewModel: ViewModel() {

    private  var cartResponse: CartRepository = CartRepository()
    private var listCart: MutableLiveData<List<Cart>> = MutableLiveData()

    fun getCart():MutableLiveData<List<Cart>> {
        return  this.listCart
    }

    fun getCartByUser(idUser: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = cartResponse.getCartByUser(idUser)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
    fun getCartDetailByCart(idCart: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = cartResponse.getCartDetailByCart(idCart)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}