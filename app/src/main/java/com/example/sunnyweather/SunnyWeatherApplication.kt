package com.example.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * Created by Ethan On 2022/5/6 18:47
 * God bless my code!
 */
class SunnyWeatherApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context:Context
        //TODO 申请的令牌传入
        const val TOKEN = "2fVSO0B3p5FBVqCg"
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}