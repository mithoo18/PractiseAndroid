package com.example.practiseandroid.MVVM_Retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practiseandroid.MVVM_Retrofit.model.ServicesSetterGetter
import com.example.practiseandroid.MVVM_Retrofit.repository.MainActivityRepository

class MVVM_Retrofit_ViewModel :ViewModel(){

    var serviceLiveData : MutableLiveData<ServicesSetterGetter>? = null

    fun getUser() : LiveData<ServicesSetterGetter>?{
        serviceLiveData = MainActivityRepository.getServiceApiCall()
        return serviceLiveData
    }


}