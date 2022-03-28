package com.example.practiseandroid.BoundService

import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.os.Messenger
import com.example.practiseandroid.R
import com.example.practiseandroid.databinding.ActivityBoundServiceBinding

class BoundServiceActivity : AppCompatActivity() {

/*
    private var myService : Messenger? = null
    private var isBound = false
    private lateinit var binding : ActivityBoundServiceBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoundServiceBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

        fab.setOnClickListener {
            sendMessage()
        }
        bindService()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(myServiceConnection)
    }

    override fun bindService(service: Intent?, conn: ServiceConnection, flags: Int): Boolean {
        return super.bindService(service, conn, flags)
    }

    private fun sendMessage() {
        if(!isBound) return

        val msg = Message.obtain()
        msg.what = WHAT_MSG_DATA
    }
*/

}