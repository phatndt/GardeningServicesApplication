package com.example.gardeningservices.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.R
import com.example.gardeningservices.model.Address

class AddressAdapter(private val mContext: Context, private val mList : List<Address>) : RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {
    class AddressViewHolder(view: View) : RecyclerView.ViewHolder (view){
        val name : TextView = view.findViewById(R.id.address_name)
        val number : TextView = view.findViewById(R.id.address_phone)
        val address : TextView = view.findViewById(R.id.address_add)
        val province : TextView = view.findViewById(R.id.address_province)
        val district : TextView = view.findViewById(R.id.address_district)
        val ward : TextView = view.findViewById(R.id.address_ward)
        val btnEdit : AppCompatButton = view.findViewById(R.id.address_btn_edit)
        val btnDelete : ImageView = view.findViewById(R.id.address_btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        return AddressViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_address, parent, false))
    }

    override fun getItemCount(): Int {
        return mList.size;
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {

        holder.name.text = mList[position].address_name
        holder.number.text = mList[position].address_number
        holder.address.text = mList[position].address_line
        holder.province.text = mList[position].province
        holder.district.text = mList[position].district
        holder.ward.text = mList[position].ward

        setUpEvent(holder, position)
    }

    private fun setUpEvent(holder: AddressViewHolder, position: Int) {

        holder.btnDelete.setOnClickListener {

        }
        holder.btnEdit.setOnClickListener {

        }
    }
}