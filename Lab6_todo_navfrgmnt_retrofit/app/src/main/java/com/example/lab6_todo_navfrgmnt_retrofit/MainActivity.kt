package com.example.lab6_todo_navfrgmnt_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.lab6_todo_navfrgmnt_retrofit.API.ApiService
import com.example.lab6_todo_navfrgmnt_retrofit.Model.Category
import com.example.lab6_todo_navfrgmnt_retrofit.Model.Country
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://saurav.tech/NewsAPI/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        apiService = retrofit.create(ApiService::class.java)

        countryList = ArrayList()

        categoryList = ArrayList()

        categoryList.add(Category("business","entertainment","general","health","science","sports","technology"))

        countryList.add(Country("India","in"))
        countryList.add(Country("USA","us"))
        countryList.add(Country("Australia","aau"))
        countryList.add(Country("Russia","ru"))
        countryList.add(Country("France","fr"))
        countryList.add(Country("United Kingdom","gb"))

    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host_fragment).navigateUp()

    companion object {
        lateinit var countryList: MutableList<Country>
        lateinit var apiService: ApiService
        lateinit var categoryList: MutableList<Category>

    }

}

