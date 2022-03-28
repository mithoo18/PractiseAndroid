package com.example.practiseandroid.BasicMVP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiseandroid.R
import com.example.practiseandroid.databinding.ActivityMainBinding
import com.example.practiseandroid.databinding.ActivityMvpactivityBinding

class MVPActivity : AppCompatActivity(),MVPView {
    private lateinit var binding : ActivityMvpactivityBinding

    private val mvpPresenter : MVPPresenter by lazy {
        MVPPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpactivityBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            btnSubmit.setOnClickListener {
                val email = edtxEmail.text.toString()
                val name = edtxName.text.toString()
                mvpPresenter.updateUserInfo(name,email)
            }
        }
    }

    override fun updateUserInfoTextView(info: String?) {
    binding.txtUserinfo.text = info
    }
}