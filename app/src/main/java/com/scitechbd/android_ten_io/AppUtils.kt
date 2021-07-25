package com.scitechbd.android_ten_io

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


fun showSnackMsg(context: AppCompatActivity, message: String?) {
    Snackbar.make(context.findViewById(android.R.id.content), "" + message, Snackbar.LENGTH_SHORT)
        .show()
}


fun showDevSnackMsg(context: AppCompatActivity, message: String?) {
    Snackbar.make(
        context.findViewById(android.R.id.content),
        "DevMessage: $message",
        Snackbar.LENGTH_SHORT
    ).show()
}

fun showSnackMsgLong(context: AppCompatActivity, message: String?) {
    Snackbar.make(context.findViewById(android.R.id.content), "" + message, Snackbar.LENGTH_LONG)
        .show()
}

fun showToast(context: Context, message: String?) {
    Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show()
}

fun logThis(message: String?) {
    Log.e("mainActivity", "$message")
}

fun logThis(TAG: String? = "", message: String? = "") {
    Log.e(TAG, "$message")
}

inline fun tryThis(message: String = "", action: () -> Unit) {
    try {
        action()
    } catch (t: Throwable) {
        logThis("Failed to $message. ${t.message}")
        t.printStackTrace()
    }
}

inline fun tryThis(action: () -> Unit) {
    try {
        action()
    } catch (t: Throwable) {
        logThis("Failed to ---> ${t.message}")
        t.printStackTrace()
    }
}

inline fun tryWithErrorDialog(
    context: Context,
    errorTitle: String = "Unexpected error!",
    action: () -> Unit
) {
    try {
        action()
    } catch (e: Throwable) {
        AlertDialog.Builder(context).create()
            .simpleErrorDialog(errorTitle, "dev message -> ${e.cause}${e.message}")
        logThis("Failed to ---> ${e.message}")
        e.printStackTrace()
    }
}

fun AlertDialog.simpleErrorDialog(title: String, body: String = "", cancelable: Boolean = true) {
    this.setTitle(title)
    this.setMessage(body)
    this.setCancelable(cancelable)
    this.setButton(AlertDialog.BUTTON_NEUTRAL, "OK") { dialog, _ -> dialog.dismiss() }
    this.create()
    this.show()
}