package com.example.practiseandroid.BoundService

import android.app.Application
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyBoundService : Service() {
    /*
    override fun onBind(intent: Intent?): IBinder? {
       Toast.makeText(applicationContext,
       "On Bind Service",
       Toast.LENGTH_LONG).show()

       // return messenger.binder
    }

    private class IncomingHandler(private val applicationContet: Context){
        Handler(Looper.getMailLo)

    }*/
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}