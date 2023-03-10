package com.example.myapplication

import android.app.IntentService
import android.content.Intent
import android.util.Log

@Suppress("DEPRECATION")
class MyIntentService: IntentService("My IntentService"){
init {
    instance = this
}
    companion object{
        private lateinit var instance: MyIntentService
        var isRunning = false
        fun stopService() {
            Log.d("My IntentService", "Service is stopping")
            isRunning = false
            instance.stopSelf()
        }
    }
    override fun onHandleIntent(p0: Intent?) {
    try {
        isRunning = true
        while(isRunning){
            Log.d("My IntentService", "Service is running")
            Thread.sleep(1000)
        }
    }catch (e: InterruptedException){
        Thread.currentThread().interrupt()
    }
    }
}