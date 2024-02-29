package com.example.kotlin_multiplatform.android

import android.app.Application
import com.example.kotlin_multiplatform.android.di.DatabaseModule
import com.example.kotlin_multiplatform.android.di.viewModelModule
import com.example.kotlin_multiplatform.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedModule + viewModelModule+ DatabaseModule

        startKoin {
            androidContext(this@MyApplication)
            modules(modules)
        }
    }
}