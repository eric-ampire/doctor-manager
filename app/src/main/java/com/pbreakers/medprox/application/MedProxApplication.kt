package com.pbreakers.medprox.application

import android.app.Application
import com.sendbird.android.SendBird

class MedProxApplication : Application() {
    private val applicationApi = "64AB1E71-5006-4029-842C-E18D8DDE3DE9"
    private val tokenApi = "b2af211eb8d0dc8a03a2fd226ba90ed9142587a6"

    override fun onCreate() {
        super.onCreate()
        SendBird.init(applicationApi, applicationContext)
    }
}