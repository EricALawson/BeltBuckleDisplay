package com.example.beltbuckledisplay

import android.app.Application
import com.example.beltbuckledisplay.database.DisplayStateDatabase

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DisplayStateDatabase.setContext(this)
    }
}