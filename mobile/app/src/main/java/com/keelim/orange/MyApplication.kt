package com.keelim.orange

import android.app.Application
import com.keelim.orange.common.ThemeHelper
import com.keelim.orange.common.ThemeType
import com.keelim.orange.utils.ComponentLogger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class MyApplication : Application() {

    @Inject
    lateinit var componentLogger: ComponentLogger
    override fun onCreate() {
        super.onCreate()
//        KakaoSdk.init(this, TODO())

        componentLogger.initialize(this)
        ThemeHelper.applyTheme(ThemeType.DEFAULT)
    }
}