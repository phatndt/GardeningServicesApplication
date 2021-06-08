package com.example.gardeningservices.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.R
import com.example.gardeningservices.model.CartDetail
import com.example.gardeningservices.model.Products
import com.example.gardeningservices.utilities.Converter

class CartAdapter(private val mContext: Context, private val mList:List<CartDetail>, private  val mListProduct:List<Products>): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_cart_image)
        val tvName: TextView = view.findViewById(R.id.item_cart_name)
        val tvPrice: TextView = view.findViewById(R.id.item_cart_price)
        val imageVDelete: ImageView = view.findViewById(R.id.item_cart_delete)
        val imageVIncrease: ImageView = view.findViewById(R.id.item_cart_increase)
        val imageVDecrease: ImageView = view.findViewById(R.id.item_cart_decrease)
        val edt: EditText = view.findViewById(R.id.item_cart_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return  CartViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_cart,parent,false))
    }

    override fun getItemCount(): Int {
        return mListProduct.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        if (mListProduct[position].image != null) {
            holder.imageView.setImageBitmap(Converter(mListProduct[position].image).DecodeToImage())
        }
        holder.tvName.text = mListProduct[position].name
        holder.tvPrice.text = mListProduct[position].price
        holder.edt.setText(mList[position].quantity.toString())

        setUp(holder,position)
    }
    private fun setUp(holder: CartViewHolder, position: Int) {
        holder.imageVDelete.setOnClickListener {

        }
    }
}