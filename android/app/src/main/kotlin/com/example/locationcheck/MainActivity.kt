//package com.example.locationcheck
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import io.flutter.embedding.android.FlutterActivity
//import io.flutter.plugin.common.MethodChannel
//import io.flutter.plugins.GeneratedPluginRegistrant
//
//class MainActivity : FlutterActivity() {
//    private val CHANNEL = "com.example.locationcheck/location"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Register method channel
//        MethodChannel(flutterEngine!!.dartExecutor, CHANNEL).setMethodCallHandler { call, result ->
//            when (call.method) {
//                "startBackgroundLocation" -> {
//                    startLocationTracking()
//                    result.success("Location tracking started")
//                }
//                else -> {
//                    result.notImplemented()
//                }
//            }
//        }
//    }
//
//    // Start the location tracking (method from your LocationService)
//    private fun startLocationTracking() {
//        val locationService = LocationService(this, flutterEngine!!.dartExecutor)
//        locationService.startLocationTracking()
//    }
//}
package com.example.locationcheck

import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel



class MainActivity : FlutterActivity() {

    private val CHANNEL = "com.example.locationcheck/location"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        flutterEngine?.dartExecutor?.let {
            MethodChannel(it, CHANNEL).setMethodCallHandler { call, result ->
                when (call.method) {
                    "startBackgroundLocation" -> {
                        val locationService = LocationService(applicationContext, flutterEngine!!.dartExecutor.binaryMessenger)
                        locationService.startLocationTracking()
                        result.success("Location tracking started")
                    }

                    else -> {
                        result.notImplemented()
                    }
                }
            }
        }
    }
}

