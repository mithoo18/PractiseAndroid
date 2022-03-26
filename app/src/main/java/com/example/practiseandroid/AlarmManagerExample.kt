package com.example.practiseandroid

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AlarmManagerExample : AppCompatActivity() {
    lateinit var start: Button
    lateinit var text : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_manager_example)

        start = findViewById<Button>(R.id.button)
        text = findViewById<EditText>(R.id.time)

        start.setOnClickListener {
            startAlert()
        }
    }

    private fun startAlert() {
        val i  = Integer.parseInt(text.text.toString())
        val intent : Intent = Intent(this,MyBroadcastReceiver::class.java)

        val pendingIntent : PendingIntent = PendingIntent.getBroadcast(this.applicationContext,
            234324243,intent,0)

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()
         + (i*1000),pendingIntent)
        Toast.makeText(this,"Alarm Set" + i + "Seconds",Toast.LENGTH_LONG).show()

    }
}