package com.example.practiseandroid.MVVM_Retrofit.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.practiseandroid.MVVM_Retrofit.model.Links
import com.example.practiseandroid.MVVM_Retrofit.model.Self
import com.example.practiseandroid.MVVM_Retrofit.model.ServicesSetterGetter
import com.example.practiseandroid.MVVM_Retrofit.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val ServicesSetterGetter = MutableLiveData<ServicesSetterGetter>()

    fun getServiceApiCall() : MutableLiveData<ServicesSetterGetter>{

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object : Callback<ServicesSetterGetter>{
            override fun onFailure(call: Call<ServicesSetterGetter>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }
            override fun onResponse(
                call: Call<ServicesSetterGetter>,
                response: Response<ServicesSetterGetter>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                //val data = response.body()
                val msg = response.body()?.message
                val link = response.body()?._links

                Log.d("checking","message"+ msg + "links" + link)
                ServicesSetterGetter.value = ServicesSetterGetter(link!!,msg!!)
            }
        })
        return ServicesSetterGetter
    }

}