package com.example.practiseandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView

class OnSaveInstanceState : AppCompatActivity() {

    private lateinit var counterTextView : TextView
    private var countValue = 0

    companion object{
     const val SCORE_KEY = "score_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_save_instance_state)
        displayCounter()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(SCORE_KEY,countValue)
    }

    override fun onRestoreInstanceState(outState: Bundle) {
        super.onRestoreInstanceState(outState)
        outState.putInt(SCORE_KEY,countValue)
    }

    fun incrementCounter(view : View){
        countValue += 1
        displayCounter()
    }

    fun decrementCounter(view : View){
        countValue -= 1
        displayCounter()
    }

    fun displayCounter(){
        counterTextView.text = countValue.toString()
    }

}