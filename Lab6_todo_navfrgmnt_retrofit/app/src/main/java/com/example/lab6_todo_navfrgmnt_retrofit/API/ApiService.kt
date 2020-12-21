package com.example.lab6_todo_navfrgmnt_retrofit.API

import com.example.lab6_todo_navfrgmnt_retrofit.Model.News
import retrofit2.Call
import retrofit2.http.*

public interface ApiService {

    @GET("top-headlines/category/{category}/{IsoCode}.json")
    fun getNews(@Path("IsoCode") IsoCode: String,
                @Path("category") category: String
    ): Call<MutableList<News>>


}

