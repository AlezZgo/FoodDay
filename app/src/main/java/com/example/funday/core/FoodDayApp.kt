package com.example.funday.core

import android.app.Application
import com.example.funday.di.DaggerApplicationComponent

class FoodDayApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}