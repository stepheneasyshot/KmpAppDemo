package com.stephen.kmpdemo.android

import android.app.Application
import com.tencent.bugly.crashreport.CrashReport


class KmpDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CrashReport.initCrashReport(applicationContext, "1c26f53145", true)
    }
}