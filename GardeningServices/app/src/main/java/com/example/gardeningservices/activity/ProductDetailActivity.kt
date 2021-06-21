package com.example.gardeningservices.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gardeningservices.R
import com.example.gardeningservices.model.ProductDetail
import com.example.gardeningservices.utilities.Converter
import com.example.gardeningservices.utilities.Status
import com.example.gardeningservices.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        this.productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        val intent: Intent = intent
        val id = intent.getIntExtra("id",-1)
        val idCategory = intent.getIntExtra("idCategory", -1)
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val discount = intent.getStringExtra("discount")
        val image = intent.getStringExtra("image")
        val quantity = intent.getIntExtra("quantity", -1)
        val rating = intent.getStringExtra("rating")
        val note = intent.getStringExtra("note")

        setUp(name!!, price!!, discount!!, image!!, quantity, rating!!, note!!)

        tv_back_product_detail_to_product.setOnClickListener {
            super.onBackPressed()
        }
        setUpProfile(id, idCategory)
    }
    private fun setUp(name: String, price: String, discount: String, image: String, quantity: Int, rating: String, note: String) {

        product_detail_name.text = name;
        product_detail_price.text = Converter.convertMoney(price.toInt())
        product_detail_discount.text = Converter.convertMoney(discount.toInt())
        product_detail_image.setImageBitmap(Converter(image).DecodeToImage())
        product_detail_stock.text = quantity.toString()
        product_detail_ratingBar.rating = rating.toFloat();

    }
    private fun setUpProfile(id: Int, idCategory: Int) {
        if (idCategory == 1) {
            productViewModel.getProductDetail(id).observe(this, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { idc -> setUpProgress(idc) }
                        }
                        Status.ERROR -> {
                            Toast.makeText(this@ProductDetailActivity, it.message, Toast.LENGTH_LONG).show()
                        }
                        Status.LOADING -> {
                        }
                    } }
            })
        } else {
            circularProgressBar1.visibility = View.INVISIBLE
            circularProgressBar2.visibility = View.INVISIBLE
            product_detail_stock_water.visibility = View.INVISIBLE
            product_detail_stock_light.visibility = View.INVISIBLE
        }
    }
    @SuppressLint("SetTextI18n")
    private fun setUpProgress(productDetail: ProductDetail) {
        if (productDetail.water.isNotEmpty() && productDetail.sunlight.isNotEmpty()) {
            product_detail_stock_water.text = "Water: " + productDetail.water
            product_detail_stock_light.text = "Light: " + productDetail.sunlight

            when (productDetail.water) {
                "Hourly" -> circularProgressBar1.progress = 100f
                "Daily" -> circularProgressBar1.progress = 75f
                "Weekly" -> circularProgressBar1.progress = 50f
                "Monthly" -> circularProgressBar1.progress = 25f
            }
            when (productDetail.sunlight) {
                "High" -> circularProgressBar2.progress = 100f
                "Medium" -> circularProgressBar2.progress = 60f
                "Low" -> circularProgressBar2.progress = 30f
            }
        }
    }
}