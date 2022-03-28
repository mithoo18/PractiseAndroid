package com.example.practiseandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OnSaveInstanceState : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textView: TextView
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_save_instance_state)

        if(savedInstanceState != null){
            val message : String? = savedInstanceState.getString("message")
            Toast.makeText(this,message,Toast.LENGTH_LONG).show()
            counter = savedInstanceState.getInt("counter",0)
        }

        button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView.setText( "" +counter)

        button.setOnClickListener {
            counter = Integer.valueOf(textView.getText().toString()) + 1
            textView.setText(""+counter)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("message", "This is a saved message")
        outState.putInt("counter", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt("counter", 0)
    }

}