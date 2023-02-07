package com.example.call_android_activity

import android.content.Intent
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity() {
    private val CHANNEL = "com.startActivity/testChannel"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // GeneratedPluginRegistrant.registerWith(this)

        flutterEngine?.dartExecutor?.let {
            MethodChannel(it.binaryMessenger,CHANNEL).setMethodCallHandler{ call, result ->
                if(call.method.equals("StartSecondActivity")){
                    val intent=Intent(this,ScrollingActivity::class.java)
                    startActivity(intent)
                    result.success("ActivityStarted")
                } else{
                    result.notImplemented()
                }
            }
        }
    }
}

