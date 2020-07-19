package com.milad.diver.ui.util

import java.net.InetAddress

class UtilInternetConnection {

    fun isInternetAvailable(): Boolean {
        return try {
            val ipAddress: InetAddress = InetAddress.getByName("google.com")
            !ipAddress.equals("")
        } catch (e: Exception) {
            false
        }
    }
}