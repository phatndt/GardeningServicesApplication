package com.example.gardeningservices.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.R
import com.example.gardeningservices.adapter.CategoryAdapter
import com.example.gardeningservices.databinding.ActivitySellAllCategoryBinding
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.network.ServerRetrofit
import com.example.gardeningservices.network.category.CategoryApi
import com.example.gardeningservices.viewmodel.SeeAllCategoryViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeeAllCategoryActivity : AppCompatActivity() {
    private lateinit var recycler_view : RecyclerView
    private lateinit var viewModel: SeeAllCategoryViewModel
    private lateinit var viewDataBinding: ActivitySellAllCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_all_category)
        recycler_view = findViewById(R.id.rcV_category)
        Log.i("GameFragment", "Called ViewModelProviders.of")
//        val list = seeAllCategoryViewModel.getListCategory()
//         callAPI()
//        setUpCategoryHome()
    }
    private  fun setUpCategoryHome(list: MutableList<Category>?) {
        recycler_view.setHasFixedSize(false)
        recycler_view.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        val categoryAdapter = CategoryAdapter(this@SeeAllCategoryActivity, list!!)
        Toast.makeText(this,categoryAdapter.itemCount.toString(),Toast.LENGTH_LONG).show()
        recycler_view.adapter = categoryAdapter
    }
    private fun callAPI() {
        var categoryAdapter: CategoryAdapter

        var listCategoryItem: List<Category>

        var categoryApi: CategoryApi? = null

        val getRetrofit: ServerRetrofit = ServerRetrofit()

        categoryApi= getRetrofit.getClient()!!.create(CategoryApi::class.java)

        val call: Call<List<Category>> = categoryApi!!.getAllCategory()

        call.enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                listCategoryItem = response.body()!!
                categoryAdapter = CategoryAdapter(this@SeeAllCategoryActivity,listCategoryItem )
                Toast.makeText(this@SeeAllCategoryActivity,listCategoryItem.size.toString(), Toast.LENGTH_SHORT).show()
//                recycler_view.adapter = categoryAdapter
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable?) {
                Toast.makeText(this@SeeAllCategoryActivity,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
            }
        })
    }
}