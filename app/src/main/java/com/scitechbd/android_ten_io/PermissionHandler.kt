package com.scitechbd.android_ten_io

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

object PermissionHandler {

    fun checkPermissionForPhoneStateBool(context: Context): Boolean {
        return context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermissionForReadPhoneState(context: Context) {
        try {
            ActivityCompat.requestPermissions(
                (context as Activity?)!!, arrayOf(Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_NETWORK_STATE),
                KeyFrame.READ_PHONE_STATE_PERMISSION_REQUEST_CODE
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkPermissionForReadExternalStorageBool(context: Context): Boolean {
        return context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermissionForReadExternalStorage(context: Context) {
        try {
            ActivityCompat.requestPermissions(
                (context as Activity?)!!, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                KeyFrame.READ_STORAGE_PERMISSION_REQUEST_CODE
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

     fun checkPermissionForWriteExternalStorageBool(context: Context): Boolean {
        return context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermissionForWriteExternalStorage(context: Context) {
        try {
            ActivityCompat.requestPermissions(
                (context as Activity?)!!, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                KeyFrame.WRITE_EXTERNAL_STORAGE_REQUEST_CODE
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkPermissionForCameraBool(context: Context): Boolean {
        return context.checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermissionForCamera(context: Context) {
        try {
            ActivityCompat.requestPermissions(
                (context as Activity?)!!, arrayOf(Manifest.permission.CAMERA),
                KeyFrame.CAMERA_REQUEST_CODE
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkPermissionForAccessFineLocationBool(context: Context): Boolean {
        return context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermissionForAccessFineLocation(context: Context) {
        try {
            ActivityCompat.requestPermissions(
                (context as Activity?)!!, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                KeyFrame.ACCESS_FINE_LOCATION_REQUEST_CODE
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkPermissionForAccessCoarseLocationBool(context: Context): Boolean {
        return context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermissionForAccessCoarseLocation(context: Context) {
        try {
            ActivityCompat.requestPermissions(
                (context as Activity?)!!, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                KeyFrame.ACCESS_COARSE_LOCATION_REQUEST_CODE
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkPermissionForMicrophoneBool(context: Context): Boolean {
        return context.checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermissionForMicrophone(context: Context) {
        try {
            ActivityCompat.requestPermissions(
                (context as Activity?)!!, arrayOf(Manifest.permission.RECORD_AUDIO),
                KeyFrame.MICROPHONE_REQUEST_CODE
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

     fun checkPermissionForPhoneState(context: Context): Int {
        val status = checkPermissionForPhoneStateBool(context)
        logThis("PermissionHandler.kt", "checkPermissionForPhoneState $status")
        return if (status) 0 else KeyFrame.READ_PHONE_STATE_PERMISSION_REQUEST_CODE
    }

     fun checkPermissionForMicrophone(context: Context): Int {
        val status = checkPermissionForMicrophoneBool(context)
        logThis("PermissionHandler.kt", "checkPermissionForMicrophone $status")
        return if (status) 0 else KeyFrame.MICROPHONE_REQUEST_CODE
    }

     fun checkPermissionForAccessFineLocation(context: Context): Int {
        val status = checkPermissionForAccessFineLocationBool(context)
        logThis("PermissionHandler.kt", "checkPermissionForAccessFineLocation $status")
        return if (status) 0 else KeyFrame.ACCESS_FINE_LOCATION_REQUEST_CODE
    }

     fun checkPermissionForAccessCoarseLocation(context: Context): Int {
        val status = checkPermissionForAccessCoarseLocationBool(context)
        logThis("PermissionHandler.kt", "checkPermissionForAccessCoarseLocation $status")
        return if (status) 0 else KeyFrame.ACCESS_COARSE_LOCATION_REQUEST_CODE
    }

     fun checkPermissionForCamera(context: Context): Int {
        val status = checkPermissionForCameraBool(context)
        logThis("PermissionHandler.kt", "checkPermissionForCamera $status")
        return if (status) 0 else KeyFrame.CAMERA_REQUEST_CODE
    }

     fun checkPermissionForReadExternalStorage(context: Context): Int {
        val status = checkPermissionForReadExternalStorageBool(context)
        logThis("PermissionHandler.kt", "checkPermissionForReadExternalStorage $status")
        return if (status) 0 else KeyFrame.READ_STORAGE_PERMISSION_REQUEST_CODE
    }

     fun checkPermissionForWriteExternalStorage(context: Context): Int {
        val status = checkPermissionForWriteExternalStorageBool(context)
        logThis("PermissionHandler.kt", "checkPermissionForWriteExternalStorage $status")
        return if (status) 0 else KeyFrame.WRITE_EXTERNAL_STORAGE_REQUEST_CODE
    }
}