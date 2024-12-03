//package com.example.locationcheck
//
//import android.annotation.SuppressLint
//import android.app.Notification
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.content.Context
//import android.content.pm.PackageManager
//import android.location.Location
//import android.os.Build
//import android.os.Handler
//import android.os.Looper
//import android.util.Log
//import androidx.core.app.ActivityCompat
//import androidx.core.app.NotificationCompat
//import androidx.core.content.ContextCompat
//import com.google.android.gms.location.FusedLocationProviderClient
//import com.google.android.gms.location.LocationServices
//import com.google.android.gms.tasks.OnSuccessListener
//import io.flutter.plugin.common.MethodChannel
//import io.flutter.plugin.common.BinaryMessenger
//
//class LocationService(private val context: Context, private val messenger: BinaryMessenger) {
//
//    private val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
//    private val handler = Handler(Looper.getMainLooper())
//    private val channel = "com.example.locationcheck/location"
//
//    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//    private val locationRunnable: Runnable = object : Runnable {
//        override fun run() {
//            fetchLocation()
//            handler.postDelayed(this, 10000) // Request location every 10 seconds
//        }
//    }
//
//    // Start tracking location
//    fun startLocationTracking() {
//        createNotificationChannel()
//        startForegroundService()
//        handler.post(locationRunnable) // Start fetching location periodically
//    }
//
//    private fun createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel("location_service", "Location Service", NotificationManager.IMPORTANCE_DEFAULT)
//            notificationManager.createNotificationChannel(channel)
//        }
//    }
//
//    private fun startForegroundService() {
//        val notification: Notification = NotificationCompat.Builder(context, "location_service")
//            .setContentTitle("Background Location")
//            .setContentText("Tracking location in the background")
//            .setSmallIcon(android.R.drawable.ic_menu_mylocation)
//            .build()
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            context.startForegroundService(android.content.Intent(context, LocationService::class.java))
//        } else {
//            context.startService(android.content.Intent(context, LocationService::class.java))
//        }
//    }
//
//    // Fetch current location and send it to Flutter
//    @SuppressLint("MissingPermission")
//    private fun fetchLocation() {
//        // Check if location permissions are granted
//        if (isLocationPermissionGranted()) {
//            fusedLocationClient.lastLocation.addOnSuccessListener(OnSuccessListener<Location> { location ->
//                location?.let {
//                    val locationData = "Lat: ${it.latitude}, Long: ${it.longitude}"
//                    Log.d("LocationUpdate", locationData)
//                    sendLocationToFlutter(locationData)
//                }
//            })
//        } else {
//            Log.e("LocationPermission", "Location permission not granted!")
//            // You can request permission here if not granted
//        }
//    }
//
//    // Check if the location permission is granted
//    private fun isLocationPermissionGranted(): Boolean {
//        val fineLocationPermission = ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION)
//        val coarseLocationPermission = ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION)
//
//        return fineLocationPermission == PackageManager.PERMISSION_GRANTED || coarseLocationPermission == PackageManager.PERMISSION_GRANTED
//    }
//
//    private fun sendLocationToFlutter(location: String) {
//        MethodChannel(messenger, channel).invokeMethod("updateLocation", location)
//    }
//
//    companion object {
//        private const val REQUEST_LOCATION_PERMISSION = 1
//    }
//
//    // Handle the permission request result (from the activity)
//    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        when (requestCode) {
//            REQUEST_LOCATION_PERMISSION -> {
//                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // Permission granted, fetch location
//                    fetchLocation()
//                } else {
//                    // Permission denied
//                    Log.e("LocationPermission", "Permission denied")
//                }
//            }
//        }
//    }
//
//    // Request permissions if not granted
//    fun requestLocationPermissions(activity: android.app.Activity) {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
//            // You can show an explanation to the user here if needed
//        } else {
//            ActivityCompat.requestPermissions(
//                activity,
//                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION),
//                REQUEST_LOCATION_PERMISSION
//            )
//        }
//    }
//}
//package com.example.locationcheck
//
//import android.annotation.SuppressLint
//import android.app.Notification
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.content.Context
//import android.content.pm.PackageManager
//import android.location.Location
//import android.os.Build
//import android.os.Handler
//import android.os.Looper
//import android.util.Log
//import androidx.core.app.ActivityCompat
//import androidx.core.app.NotificationCompat
//import androidx.core.content.ContextCompat
//import com.google.android.gms.location.FusedLocationProviderClient
//import com.google.android.gms.location.LocationServices
//import com.google.android.gms.tasks.OnSuccessListener
//import io.flutter.plugin.common.BinaryMessenger
//import io.flutter.plugin.common.MethodChannel
//
//class LocationService(private val context: Context, private val messenger: BinaryMessenger) {
//
//    private val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
//    private val handler = Handler(Looper.getMainLooper())
//    private val channel = "com.example.locationcheck/location"
//
//    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//    private val locationRunnable: Runnable = object : Runnable {
//        override fun run() {
//            fetchLocation()
//            handler.postDelayed(this, 10000) // Request location every 10 seconds
//        }
//    }
//
//    // Start tracking location
//    fun startLocationTracking() {
//        createNotificationChannel()
//        startForegroundService()
//        handler.post(locationRunnable) // Start fetching location periodically
//    }
//
//    private fun createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel("location_service", "Location Service", NotificationManager.IMPORTANCE_DEFAULT)
//            notificationManager.createNotificationChannel(channel)
//        }
//    }
//
//    private fun startForegroundService() {
//        val notification: Notification = NotificationCompat.Builder(context, "location_service")
//            .setContentTitle("Background Location")
//            .setContentText("Tracking location in the background")
//            .setSmallIcon(android.R.drawable.ic_menu_mylocation)
//            .build()
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            context.startForegroundService(android.content.Intent(context, LocationService::class.java))
//        } else {
//            context.startService(android.content.Intent(context, LocationService::class.java))
//        }
//    }
//
//    // Fetch current location and send it to Flutter
//    @SuppressLint("MissingPermission")
//    private fun fetchLocation() {
//        // Check if location permissions are granted
//        if (isLocationPermissionGranted()) {
//            fusedLocationClient.lastLocation.addOnSuccessListener(OnSuccessListener<Location> { location ->
//                location?.let {
//                    val locationData = "Lat: ${it.latitude}, Long: ${it.longitude}"
//                    Log.d("LocationUpdate", locationData)
//                    sendLocationToFlutter(locationData)
//                }
//            })
//        } else {
//            Log.e("LocationPermission", "Location permission not granted!")
//            // You can request permission here if not granted
//        }
//    }
//
//    // Check if the location permission is granted
//    private fun isLocationPermissionGranted(): Boolean {
//        val fineLocationPermission = ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION)
//        val coarseLocationPermission = ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION)
//
//        return fineLocationPermission == PackageManager.PERMISSION_GRANTED || coarseLocationPermission == PackageManager.PERMISSION_GRANTED
//    }
//
//    private fun sendLocationToFlutter(location: String) {
//        MethodChannel(messenger, channel).invokeMethod("updateLocation", location)
//    }
//
//    companion object {
//        private const val REQUEST_LOCATION_PERMISSION = 1
//    }
//
//    // Handle the permission request result (from the activity)
//    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        when (requestCode) {
//            REQUEST_LOCATION_PERMISSION -> {
//                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // Permission granted, fetch location
//                    fetchLocation()
//                } else {
//                    // Permission denied
//                    Log.e("LocationPermission", "Permission denied")
//                }
//            }
//        }
//    }
//
//    // Request permissions if not granted
//    fun requestLocationPermissions(activity: android.app.Activity) {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
//            // You can show an explanation to the user here if needed
//        } else {
//            ActivityCompat.requestPermissions(
//                activity,
//                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION),
//                REQUEST_LOCATION_PERMISSION
//            )
//        }
//    }
//}
package com.example.locationcheck

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.location.Location
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.BinaryMessenger
import android.Manifest
import android.content.pm.PackageManager

class LocationService(private val context: Context, private val messenger: BinaryMessenger) {

    private val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    private val handler = Handler(Looper.getMainLooper())
    private val channel = "com.example.locationcheck/location"

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    private val locationRunnable: Runnable = object : Runnable {
        override fun run() {
            fetchLocation()
            handler.postDelayed(this, 10000) // Request location every 10 seconds
        }
    }

    // Start location tracking in the background
    fun startLocationTracking() {
        if (!isLocationPermissionGranted()) {
            requestLocationPermissions()
        } else {
            createNotificationChannel()
            startForegroundService()
            handler.post(locationRunnable) // Start fetching location periodically
        }
    }

    // Check if location permission is granted
    private fun isLocationPermissionGranted(): Boolean {
        val fineLocationPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
        val coarseLocationPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
        val backgroundLocationPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_BACKGROUND_LOCATION)

        return fineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                coarseLocationPermission == PackageManager.PERMISSION_GRANTED &&
                backgroundLocationPermission == PackageManager.PERMISSION_GRANTED
    }

    // Request location permissions
    private fun requestLocationPermissions() {
        ActivityCompat.requestPermissions(
            context as android.app.Activity,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_BACKGROUND_LOCATION),
            REQUEST_LOCATION_PERMISSION
        )
    }

    // Create notification channel for foreground service
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("location_service", "Location Service", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
    }

    // Start foreground service to keep the app running in the background
    private fun startForegroundService() {
        val notification: Notification = NotificationCompat.Builder(context, "location_service")
            .setContentTitle("Background Location")
            .setContentText("Tracking location in the background")
            .setSmallIcon(android.R.drawable.ic_menu_mylocation)
            .build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(Intent(context, LocationService::class.java))
        } else {
            context.startService(Intent(context, LocationService::class.java))
        }
    }

    // Fetch current location and send it to Flutter
    @SuppressLint("MissingPermission")
    private fun fetchLocation() {
        fusedLocationClient.lastLocation.addOnSuccessListener(OnSuccessListener<Location> { location ->
            location?.let {
                val locationData = "Lat: ${it.latitude}, Long: ${it.longitude}"
                Log.d("LocationUpdate", locationData)
                sendLocationToFlutter(locationData)
            }
        })
    }

    // Send location data to Flutter
    private fun sendLocationToFlutter(location: String) {
        MethodChannel(messenger, channel).invokeMethod("updateLocation", location)
    }

    companion object {
        private const val REQUEST_LOCATION_PERMISSION = 1
    }

    // Handle the permission request result
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationTracking()
            } else {
                Log.e("LocationPermission", "Permission denied")
            }
        }
    }
}
