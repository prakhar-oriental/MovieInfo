package com.example.movieinfoapp.Api

import com.example.movieinfoapp.Data
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
     @GET("?apikey=38c6012")
   fun getMovie(@Query("t")t:String,@Query("plot")plot:String) : Call<Data>
}