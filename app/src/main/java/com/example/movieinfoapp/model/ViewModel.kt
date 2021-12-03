package com.example.movieinfoapp.model


import androidx.lifecycle.ViewModel
import com.example.movieinfoapp.Api.MovieApi
import com.example.movieinfoapp.Api.RetrofitHelper


open class ViewModel(name:String, desp:String) :ViewModel()   {

         val movieApi = RetrofitHelper.getInstance().create(MovieApi::class.java)
         val retrofitdata = movieApi.getMovie(name,desp)




}