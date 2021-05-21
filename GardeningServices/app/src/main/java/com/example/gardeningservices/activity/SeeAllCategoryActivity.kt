package com.example.gardeningservices.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.R
import com.example.gardeningservices.adapter.CategoryAdapter
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.viewmodel.CategoryViewModel

class SeeAllCategoryActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    private  val categoryViewModel by lazy {
        return@lazy ViewModelProviders.of(this).get(CategoryViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_all_category)
        recyclerView = findViewById(R.id.rcV_category)

        val imageback: ImageView = findViewById(R.id.tv_back_category)
        imageback.setOnClickListener {
            super.onBackPressed()
        }
        categoryViewModel.CallAllCategoryApi()
        observeResponseData()

    }
    private fun observeResponseData() {
        categoryViewModel.listCategory.observe(this, Observer {
            setUpCategoryHome(it)
        })
    }
    private  fun setUpCategoryHome(list: List<Category>) {
        val categoryAdapter = CategoryAdapter(this@SeeAllCategoryActivity, list)
        recyclerView.adapter = categoryAdapter
    }
}