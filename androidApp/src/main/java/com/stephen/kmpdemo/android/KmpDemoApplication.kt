package com.stephen.kmpdemo.android

import android.app.Application
import com.tencent.bugly.crashreport.CrashReport


class KmpDemoApplication : Application() {

    companion object{
        lateinit var instance: KmpDemoApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        CrashReport.initCrashReport(applicationContext, "1c26f53145", true)
    }
}

val appContext = KmpDemoApplication.instance.applicationContext
