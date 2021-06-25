package com.example.gardeningservices.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.R
import com.example.gardeningservices.model.Products
import com.example.gardeningservices.utilities.Converter

class ProductAdapter(private val mContext: Context, private val mList:List<Products>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_good,parent,false))
    }
    override fun getItemCount(): Int {
        return  mList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.productName.text = mList[position].name
        holder.productPrice.text = mList[position].price
        if(mList[position].image != ""){
            holder.productNamePicture.setImageBitmap(Converter(mList[position].image).DecodeToImage())
        }

    }
    class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val productNamePicture: ImageView = view.findViewById(R.id.tv_image_good)
        val productName: TextView = view.findViewById(R.id.tv_name_good)
        val productPrice: TextView = view.findViewById(R.id.tv_price_good)
        val productCard: CardView = view.findViewById(R.id.cv_category)
    }

}