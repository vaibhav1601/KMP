package com.example.kotlin_multiplatform

import platform.UIKit.UIDevice

actual class Platform(){
    actual val osName: String
        get() =UIDevice.currentDevice.systemName
    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion
    actual val deviceModel: String
        get() = UIDevice.currentDevice.model
    actual val density: Int
        get() = UiScreen.mainScreen.scale.toInt()

    actual fun logSystemInfo() {
    }

}