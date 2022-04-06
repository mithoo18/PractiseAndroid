package com.example.RXJAVA_Retrofit.Network

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    companion object{
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.publicapis.org/entries")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        val api : Api = retrofit.create(Api::class.java)

    }

}