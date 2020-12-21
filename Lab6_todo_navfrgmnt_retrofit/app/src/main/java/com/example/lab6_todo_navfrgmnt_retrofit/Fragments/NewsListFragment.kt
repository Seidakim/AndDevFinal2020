package com.example.lab6_todo_navfrgmnt_retrofit.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab6_todo_navfrgmnt_retrofit.MainActivity
import com.example.lab6_todo_navfrgmnt_retrofit.Model.News
import com.example.lab6_todo_navfrgmnt_retrofit.NewsListAdapter
import com.example.lab6_todo_navfrgmnt_retrofit.R
import kotlinx.android.synthetic.main.fragment_news_list.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsListFragment : Fragment() {
    lateinit var newsList: MutableList<News>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val IsoCode = arguments?.getString("Isocode")!!
        val Category1 = arguments?.getString("category")!!
        newsList = ArrayList()
        val list = ArrayList<News>()

        news_recycle_view.adapter = NewsListAdapter(newsList,view.context)
        news_recycle_view.layoutManager = LinearLayoutManager(view.context)




        MainActivity.apiService.getNews(IsoCode,Category1).enqueue(object : Callback<MutableList<News>> {
            override fun onFailure(call: Call<MutableList<News>>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
            override fun onResponse(call: Call<MutableList<News>>, response: Response<MutableList<News>>) {
                Log.e("Response size: ", response.body()!!.size.toString())
                newsList = response.body()!!
                (news_recycle_view.adapter as NewsListAdapter).notifyDataSetChanged()

            }
        })


    }
}