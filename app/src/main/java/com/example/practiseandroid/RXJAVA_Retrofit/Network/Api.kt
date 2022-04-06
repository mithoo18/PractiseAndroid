package com.example.practiseandroid.RXJAVA_Retrofit.Network

import com.example.practiseandroid.RXJAVA_Retrofit.Model.CatItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface Api {

    @GET("cats?tags=cute")
    fun getAllData() : Observable<List<CatItem>>

}