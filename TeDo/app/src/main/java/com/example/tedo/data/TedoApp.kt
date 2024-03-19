package com.example.tedo.data

import android.app.Application

/** Application is the base class that provides a starting point **/
class TedoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}