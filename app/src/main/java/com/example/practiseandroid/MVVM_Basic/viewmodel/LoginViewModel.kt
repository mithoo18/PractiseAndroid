package com.example.practiseandroid.MVVM_Basic.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.practiseandroid.MVVM_Basic.model.LoginTableModel
import com.example.practiseandroid.MVVM_Basic.repository.LoginRepository

class LoginViewModel : ViewModel(){

    var liveDataLogin : LiveData<LoginTableModel>? = null

    fun insertData(context : Context,username : String,password : String){
        LoginRepository.insertData(context,username,password)
    }

    fun getLoginDetails(context: Context,username :String) :
    LiveData<LoginTableModel>?{
        liveDataLogin = LoginRepository.getLoginDetails(context,username)
        return liveDataLogin
    }
}