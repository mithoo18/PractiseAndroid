package com.example.practiseandroid.Changing_Theme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiseandroid.R
import com.example.practiseandroid.databinding.ActivityThemeBinding
import androidx.preference.PreferenceManager

class ThemeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityThemeBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        setTheme(

            if (flag)
            R.style.AppThemeDark

            else
            R.style.AppThemeLight

            )
        super.onCreate(savedInstanceState)
        binding = ActivityThemeBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            btnChange.setOnClickListener {
                saveFlag(!flag)

                val intent : Intent = Intent(this@ThemeActivity,ThemeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private val preferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }

    private fun saveFlag(flag : Boolean){
        preferences.edit()
            .putBoolean("dark",flag)
            .apply()
    }

    private val flag : Boolean
        get() = preferences.getBoolean("dark",false)
}