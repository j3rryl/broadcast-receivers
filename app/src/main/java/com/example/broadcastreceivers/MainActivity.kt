package com.example.broadcastreceivers

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val receiver=AirplaneModeChangedReceiver()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = Intent(this,CustomReceiver::class.java)
        intent.action="com.example.CUSTOM_INTENT"
        sendBroadcast(intent)

        var receiverIntent = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver,receiverIntent)
    }

    override fun onStop() {
        super.onStop()
        val receiver=AirplaneModeChangedReceiver()
        unregisterReceiver(receiver)
    }
}