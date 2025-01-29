package com.example.test_app

import android.app.Application
import com.example.test_app.di.AppComponent
import com.example.test_app.di.DaggerAppComponent

class TestApp : Application() {
    val appComponent: AppComponent = DaggerAppComponent.create()
}