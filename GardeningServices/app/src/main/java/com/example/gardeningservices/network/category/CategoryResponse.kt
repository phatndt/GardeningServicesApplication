package com.example.gardeningservices.network.category

import android.content.Context
import android.widget.Toast
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.network.ServerRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryResponse {

    private var listCategory: MutableList<Category>? = mutableListOf()
    fun setDataCategory(list : List<Category>,context: Context) {
        listCategory = list.toMutableList()
        val list = list.toMutableList()
//        Toast.makeText(context,listCategory?.size.toString(),Toast.LENGTH_LONG).show()
       // this.list = listCategory?.toList()!!
    }
    fun getJoCategory(context: Context): MutableList<Category>? {
        return listCategory
    }
    fun getDataCategory(context: Context) {

        var categoryApi: CategoryApi? = null

        val getRetrofit: ServerRetrofit = ServerRetrofit()

        categoryApi= getRetrofit.getClient()!!.create(CategoryApi::class.java)

        val call: Call<List<Category>> = categoryApi!!.getAllCategory()

        call.enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                response.body()?.let { setDataCategory(it,context) }
                //Toast.makeText(context, listCategory!!.size.toString() , Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable?) {
                Toast.makeText(context,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
            }
        })
    }


}