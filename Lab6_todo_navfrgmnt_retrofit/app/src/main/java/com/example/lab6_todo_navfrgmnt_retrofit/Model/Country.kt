package com.example.lab6_todo_navfrgmnt_retrofit.Model

import com.google.gson.annotations.SerializedName

data class Country (
    @SerializedName("name")
    val name: String,
    @SerializedName("IsoCode")
    val IsoCode: String,

    )
