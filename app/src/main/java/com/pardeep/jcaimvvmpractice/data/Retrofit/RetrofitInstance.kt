package com.pardeep.jcaimvvmpractice.data.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val BASEURL = "https://api.restful-api.dev/"

    val api : ApiServices by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }


}