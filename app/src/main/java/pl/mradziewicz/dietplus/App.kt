package pl.mradziewicz.dietplus

import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
    companion object{
        lateinit var appContext: App
    }
}

