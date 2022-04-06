package com.example.RXJAVA_Retrofit.Network

import com.example.RXJAVA_Retrofit.Model.Food
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface Api {

    @GET("entries")
    fun getAllData() : Observable<List<Food>>

}