package com.example.contactappsql

import android.app.Application
import com.example.contactappsql.di.repositoryModule
import com.example.contactappsql.di.sqlModule
import com.example.contactappsql.di.useCaseModule
import com.example.contactappsql.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        val modules= listOf(viewModelModule,sqlModule,repositoryModule, useCaseModule)
        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            koin.loadModules(modules)
        }
    }

}