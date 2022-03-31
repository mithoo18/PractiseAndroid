package com.example.practiseandroid.MVVM_Retrofit.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.practiseandroid.MVVM_Retrofit.viewmodel.MVVM_Retrofit_ViewModel
import com.example.practiseandroid.R
import kotlinx.android.synthetic.main.activity_mvvm_retrofit.*

class MVVM_Retrofit_Activity : AppCompatActivity() {

    lateinit var context : Context
    lateinit var mvvm_Retrofit_ViewModel : MVVM_Retrofit_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_retrofit)

        context = this@MVVM_Retrofit_Activity

        mvvm_Retrofit_ViewModel = ViewModelProvider(this).get(MVVM_Retrofit_ViewModel::class.java)

        btnClick.setOnClickListener {
            mvvm_Retrofit_ViewModel.getUser()!!.observe(this, Observer { serviceSetterGetter ->
                val msg = serviceSetterGetter.message
                lblResponse.text = msg
            })

        }

    }
}