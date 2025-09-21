package com.stephen.kmpdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform