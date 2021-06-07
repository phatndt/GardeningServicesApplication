package com.example.gardeningservices.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.R
import com.example.gardeningservices.model.PlantDetail
import com.example.gardeningservices.utilities.Converter

class PlantDetailAdapter(private val mContext: Context, private val mList:List<PlantDetail>):RecyclerView.Adapter<PlantDetailAdapter.PlantDetailViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlantDetailAdapter.PlantDetailViewHolder {
        return PlantDetailViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_plant_detail,parent,false))
    }

    override fun onBindViewHolder(holder: PlantDetailAdapter.PlantDetailViewHolder, position: Int) {
        holder.plantName.text = mList[position].name
        holder.plantPicture.setImageBitmap(Converter(mList[position].image).DecodeToImage())
        holder.plantPicture.setColorFilter(ContextCompat.getColor(mContext,R.color.Green1))
        holder.plantPrice.text = mList[position].price
        holder.plantQuantity.text = mList[position].quantity
        holder.plantRating.text = mList[position].rating
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class PlantDetailViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val plantName: TextView = view.findViewById(R.id.tv_name_pd)
        val plantPicture: ImageView = view.findViewById(R.id.tv_image_pd)
        val plantStarRating: RatingBar = view.findViewById(R.id.ratingBar)
        val plantRating: TextView = view.findViewById(R.id.rating)
        val plantPrice:TextView = view.findViewById(R.id.tv_price_pd)
        val plantQuantity:TextView = view.findViewById(R.id.pd_quantity)
        val plantCard :CardView = view.findViewById(R.id.cv_plant_detail)
    }
}