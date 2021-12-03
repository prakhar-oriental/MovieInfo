package com.example.movieinfoapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFactory(private val name:String,private val desp:String) :  ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return ViewModel(name,desp) as T


        throw IllegalArgumentException("Unknown view Model Class")
    }
}