package com.example.practiseandroid.Builder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiseandroid.R
import com.example.practiseandroid.databinding.ActivityBuilderBinding
import com.google.android.material.snackbar.Snackbar

class BuilderActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBuilderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuilderBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            val user = User.UserBuilder("Nishant","Srivastava")
                .age(24)
                .phone("0987654321")
                .address("my address")
                .build()

            val text = user.firstname + " " + user.lastName

            fab.setOnClickListener {
                view ->
                Snackbar.make(view,text,Snackbar.LENGTH_LONG).show()
            }
        }
    }
}