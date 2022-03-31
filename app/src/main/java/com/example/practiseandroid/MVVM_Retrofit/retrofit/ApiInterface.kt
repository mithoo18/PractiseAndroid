package com.example.practiseandroid.MVVM_Retrofit.retrofit

import com.example.practiseandroid.MVVM_Retrofit.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("service")
    fun getServices() : Call<ServicesSetterGetter>

}