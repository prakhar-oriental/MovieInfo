package com.example.movieinfoapp

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movieinfoapp.Api.MovieApi
import com.example.movieinfoapp.Api.RetrofitHelper
import com.example.movieinfoapp.databinding.ActivityMainBinding
import com.example.movieinfoapp.model.ViewModel
import com.example.movieinfoapp.model.ViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding:ActivityMainBinding
    lateinit var viewmodel:ViewModel
    lateinit var viewModelFactory: ViewModelFactory


    lateinit var movieApi: MovieApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val movienamea = dataBinding.name.text.toString()
        val moviedespa = dataBinding.desp.text.toString()
           viewModelFactory = ViewModelFactory(moviedespa,moviedespa)
           viewmodel = ViewModelProvider(this,viewModelFactory).get(ViewModel::class.java)

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

            dataBinding.buttonclick.setOnClickListener {


                val moviename = dataBinding.name.text.toString()
                val moviedesp = dataBinding.desp.text.toString()

                    if(moviename.isEmpty())
                    {
                        dataBinding.name.setError("fill this")
                    }else if(moviedesp.isEmpty())
                    {
                        dataBinding.desp.setError("fill this")
                    }else {
                        val movieApi = RetrofitHelper.getInstance().create(MovieApi::class.java)
                        val retrofitdata = movieApi.getMovie(moviename, moviedesp)
                        retrofitdata.enqueue(object : Callback<Data?> {
                            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                                var quotelist = response.body()
                                    var x:String = quotelist!!.Response

                                      if(x=="False")
                                      {
                                          Log.d("vedan","no movie")
                                          Toast.makeText(this@MainActivity,"No movie avilable with this name",Toast.LENGTH_SHORT).show()
                                      }else
                                      {
                                          dataBinding.Titlev.isVisible = true
                                    dataBinding.releasedv.isVisible = true
                                    dataBinding.runtimev.isVisible = true
                                    dataBinding.genrev.isVisible = true
                                    dataBinding.actorsv.isVisible = true
                                    dataBinding.directorv.isVisible = true
                                    dataBinding.writerv.isVisible = true
                                    dataBinding.imdbv.isVisible= true
                                    dataBinding.boxofficev.isVisible = true
                                    dataBinding.plotv.isVisible = true


                                    dataBinding.Titlev.text = quotelist.Title
                                    dataBinding.releasedv.text = quotelist.Released
                                    dataBinding.runtimev.text = quotelist.Runtime
                                    dataBinding.genrev.text = quotelist.Genre
                                    dataBinding.actorsv.text = quotelist.Actors
                                    dataBinding.directorv.text = quotelist.Director
                                    dataBinding.writerv.text = quotelist.Writer
                                    dataBinding.imdbv.text = quotelist.imdbRating
                                    dataBinding.boxofficev.text = quotelist.BoxOffice
                                    dataBinding.plotv.setText("Plot : "+quotelist.Plot)
                                    Glide.with(applicationContext).load(quotelist.Poster)
                                        .into(dataBinding.imageView)

                                      }

                            }

                            override fun onFailure(call: Call<Data?>, t: Throwable) {

                                Log.d("dan","empty")
                                Toast.makeText(this@MainActivity,"not available",Toast.LENGTH_SHORT).show()
                            }
                        })
                    }
            }




         }


}
