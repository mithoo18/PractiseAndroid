package com.example.practiseandroid.SwipeSample


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface API {

    companion object{
        operator fun invoke() : API{
            return Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API::class.java)
        }

    }

    @GET("profiles")
    fun getProfiles() : Call<List<Profile>>



}