package com.example.movieinfoapp.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val BASE_URL = "https://www.omdbapi.com/"

    fun getInstance():Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}