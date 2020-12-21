package com.example.lab6_todo_navfrgmnt_retrofit.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab6_todo_navfrgmnt_retrofit.CountryListAdapter
import com.example.lab6_todo_navfrgmnt_retrofit.R
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_country_list.*


class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_category, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val Isocode = arguments?.getInt("Isocode")!!

        category_entertainment.setOnClickListener{
            val bundle = bundleOf("entertainment" to "category", "Isocode" to Isocode)
            view.findNavController().navigate(R.id.action_categoryFragment_to_newsListFragment, bundle)
        }

        category_business.setOnClickListener{
            val bundle = bundleOf("business" to "category", "Isocode" to Isocode)
            view.findNavController().navigate(R.id.action_categoryFragment_to_newsListFragment, bundle)
        }

        category_general.setOnClickListener{
            val bundle = bundleOf("general" to "category", "Isocode" to Isocode)
            view.findNavController().navigate(R.id.action_categoryFragment_to_newsListFragment, bundle)
        }

        category_health.setOnClickListener{
            val bundle = bundleOf("health" to "category", "Isocode" to Isocode)
            view.findNavController().navigate(R.id.action_categoryFragment_to_newsListFragment, bundle)
        }

        category_science.setOnClickListener{
            val bundle = bundleOf("science" to "category", "Isocode" to Isocode)
            view.findNavController().navigate(R.id.action_categoryFragment_to_newsListFragment, bundle)
        }

        category_sports.setOnClickListener{
            val bundle = bundleOf("sports" to "category", "Isocode" to Isocode)
            view.findNavController().navigate(R.id.action_categoryFragment_to_newsListFragment, bundle)
        }

        category_technology.setOnClickListener{
            val bundle = bundleOf("technology" to "category", "Isocode" to Isocode)
            view.findNavController().navigate(R.id.action_categoryFragment_to_newsListFragment, bundle)
        }

    }

}