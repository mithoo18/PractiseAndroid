package com.example.practiseandroid.MVVM_Basic.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class LoginDatabase : RoomDatabase() {

    abstract fun loginDao() : DAOAccess

    companion object{

        @Volatile
        private var INSTANCE : LoginDatabase? = null

        fun getDataseClient(context : Context) : LoginDatabase{

            if(INSTANCE != null) return INSTANCE!!

            synchronized(this){

                INSTANCE = Room
                    .databaseBuilder(context,LoginDatabase::class.java,"LOGIN_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!
            }

        }
    }

}