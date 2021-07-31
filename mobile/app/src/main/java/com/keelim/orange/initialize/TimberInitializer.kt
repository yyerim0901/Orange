package com.keelim.orange.initialize

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber
import com.keelim.orange.BuildConfig
import com.keelim.orange.utils.CrashlyticsTree

class TimberInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashlyticsTree())
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}