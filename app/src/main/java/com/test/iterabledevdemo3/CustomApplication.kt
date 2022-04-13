package com.test.iterabledevdemo3

import android.app.Application
import com.iterable.iterableapi.IterableApi

import com.iterable.iterableapi.IterableConfig




class CustomApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val configBuilder = IterableConfig.Builder().setAllowedProtocols(arrayOf("http", "tel", "custom"))
        IterableApi.initialize(this, "349dcc9373c74c6699c5d1204a271695", configBuilder.build())
        IterableApi.getInstance().setEmail("antturley@gmail.com")

    }
}