package com.stephen.kmpdemo

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, Kotlin Multiplatform on ${platform.name}!"
    }
}