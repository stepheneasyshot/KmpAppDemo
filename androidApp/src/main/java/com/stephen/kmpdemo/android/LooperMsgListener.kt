package com.stephen.kmpdemo.android

import android.os.Looper
import android.util.Log

object LooperMsgListener {

    private var lastFrameTime: Long = 0

    fun startCheckFrameTime() {
        Log.i("卡顿监控", "startCheckFrameTime")
        lastFrameTime = System.currentTimeMillis()
        Looper.getMainLooper().setMessageLogging { msg ->
            val currentTime = System.currentTimeMillis()
            if (lastFrameTime != 0L) {
                val diffTime = currentTime - lastFrameTime
                if (diffTime > 16) {
                    Log.d("卡顿监控", "卡顿检测: $diffTime ms")
                }
            }
            lastFrameTime = currentTime
        }
    }

    fun stopCheckFrameTime() {
        Log.i("卡顿监控", "stopCheckFrameTime")
        Looper.getMainLooper().setMessageLogging(null)
    }
}