package com.example.lab6_todo_navfrgmnt_retrofit.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab6_todo_navfrgmnt_retrofit.CountryListAdapter
import com.example.lab6_todo_navfrgmnt_retrofit.R
import kotlinx.android.synthetic.main.fragment_country_list.*


class CountryListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        country_recycle_view.adapter = CountryListAdapter(view.context)
        country_recycle_view.layoutManager = LinearLayoutManager(view.context)

    }

}