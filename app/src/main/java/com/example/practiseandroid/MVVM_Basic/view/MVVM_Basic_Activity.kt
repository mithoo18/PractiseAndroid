package com.example.practiseandroid.MVVM_Basic.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.practiseandroid.MVVM_Basic.viewmodel.LoginViewModel
import com.example.practiseandroid.R
import kotlinx.android.synthetic.main.activity_mvvm_basic.*

class MVVM_Basic_Activity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel
    lateinit var context : Context
    lateinit var strUsername : String
    lateinit var strPassword : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_basic)

        context = this@MVVM_Basic_Activity
        // TODO loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        btnAddLogin.setOnClickListener {
            strUsername = txtUsername.text.toString().trim()
            strPassword = txtPassword.text.toString().trim()

            if(strPassword.isEmpty()){
                txtUsername.error = "Please enter the username"
            }
            else if(strPassword.isEmpty()){
                txtPassword.error = "Please enter the username"
            }
            else{
             //TODO loginViewModel.insertData(context,strUsername,strPassword)
             //TODO lblInsertResponse.text = "Insert Successfully"
            }
        }

        btnReadLogin.setOnClickListener {

            strUsername = txtUsername.text.toString().trim()

            //TODO loginViewModel.getLoginDetails(context,strUsername)!!.observe(this,observer{

            if(it == null) {}

            else{}

        }

    }
}