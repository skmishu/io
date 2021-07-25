package com.scitechbd.android_ten_io

import android.annotation.SuppressLint

object KeyFrame {

    //permission handler code
    const val READ_STORAGE_PERMISSION_REQUEST_CODE: Int = 941
    const val WRITE_EXTERNAL_STORAGE_REQUEST_CODE: Int = 942
    const val CAMERA_REQUEST_CODE: Int = 943
    const val ACCESS_FINE_LOCATION_REQUEST_CODE: Int = 944
    const val ACCESS_COARSE_LOCATION_REQUEST_CODE: Int = 945
    const val MICROPHONE_REQUEST_CODE: Int = 946
    const val READ_PHONE_STATE_PERMISSION_REQUEST_CODE: Int = 947

    //file handler
    //todo: get directory path from shared pref location as getDir()
    @SuppressLint("SdCardPath")
    const val FILE_PATH_PREFIX_FROM_CACHE: String = "/data/user/0/com.scitechbd.mukherkotha/cache/"

}