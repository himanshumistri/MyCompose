package com.himanshu.utility


import android.util.Log

/**
 * AI Generated
 */ object LogcatManager {

    private val TAG = "LogcatManager"

    private var isLogcatEnabled = true

    fun setLogcatEnabled(isLogcatEnabled: Boolean) {
        this.isLogcatEnabled = isLogcatEnabled
    }

    fun v(tag: String, message: String) {
        if (isLogcatEnabled) {
            Log.v(tag, message)
        }
    }

    fun d(tag: String, message: String) {
        if (isLogcatEnabled) {
            Log.d(tag, message)
        }
    }

    fun i(tag: String, message: String) {
        if (isLogcatEnabled) {
            Log.i(tag, message)
        }
    }

    fun w(tag: String, message: String) {
        if (isLogcatEnabled) {
            Log.w(tag, message)
        }
    }

    fun e(tag: String, message: String) {
        if (isLogcatEnabled) {
            Log.e(tag, message)
        }
    }
}
