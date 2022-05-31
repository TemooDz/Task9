package com.example.homework9

import android.app.Application
import androidx.room.Room
import com.example.homework9.db.AppDataBase

class App : Application() {

    lateinit var db: AppDataBase

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "database-name"
        ).build()
        ApiClient.initClients()
        instance = this

    }
}