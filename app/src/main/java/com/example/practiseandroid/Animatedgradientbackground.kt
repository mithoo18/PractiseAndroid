package com.example.practiseandroid

import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiseandroid.databinding.ActivityAnimatedgradientbackgroundBinding

class Animatedgradientbackground : AppCompatActivity() {

    private lateinit var binding : ActivityAnimatedgradientbackgroundBinding
    private lateinit var animatedDrawable : AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimatedgradientbackgroundBinding.inflate(layoutInflater)

        binding.apply {
            setContentView(root)
            animatedDrawable = constraintLayout.background as AnimationDrawable
        }
        supportActionBar?.hide()

        animatedDrawable?.apply {
            setEnterFadeDuration(5000)
            setExitFadeDuration(2000)
        }
    }

    override fun onResume() {
        super.onResume()
        if(animatedDrawable != null && animatedDrawable?.isRunning?.not() == true){
            animatedDrawable?.start()
        }
    }

    override fun onPause() {
        super.onPause()
        if(animatedDrawable != null && animatedDrawable?.isRunning == true){
            animatedDrawable?.stop()
        }
    }


}