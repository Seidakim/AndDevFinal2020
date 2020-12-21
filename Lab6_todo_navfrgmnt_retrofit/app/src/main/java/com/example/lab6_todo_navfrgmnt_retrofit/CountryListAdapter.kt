package com.example.lab6_todo_navfrgmnt_retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CountryListAdapter(
    val context: Context,
) : RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.country_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val country = MainActivity.countryList[position]
        holder.countryNameText.text = country.name
        holder.countryIsoText.text = country.IsoCode
        holder.itemView.setOnClickListener {
            val bundle = bundleOf("Isocode" to country.IsoCode)
            it.findNavController().navigate(R.id.action_countryListFragment_to_categoryFragment,bundle)
        }

    }

    override fun getItemCount(): Int {
        return MainActivity.countryList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryNameText: TextView = itemView.findViewById(R.id.country_name)
        var countryIsoText: TextView = itemView.findViewById(R.id.country_name)
    }

}