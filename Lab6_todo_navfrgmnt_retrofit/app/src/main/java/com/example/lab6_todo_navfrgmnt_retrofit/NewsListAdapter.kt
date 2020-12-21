package com.example.lab6_todo_navfrgmnt_retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6_todo_navfrgmnt_retrofit.Model.News

class NewsListAdapter(
    var newsList: MutableList<News>,
    val context: Context,
) : RecyclerView.Adapter<NewsListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news = newsList[position]
        holder.newsTitleText.text = news.title


        holder.itemView.setOnClickListener {
//            val bundle = bundleOf("countrylan" to task.id, "userId" to task.userId)
            it.findNavController().navigate(R.id.action_newsListFragment_to_detailFragment)
        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var newsTitleText: TextView = itemView.findViewById(R.id.news_title)
    }

}