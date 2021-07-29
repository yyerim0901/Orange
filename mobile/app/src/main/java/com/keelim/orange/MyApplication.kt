package com.keelim.orange

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.kakao.sdk.common.KakaoSdk
import com.keelim.orange.data.repository.theme.ThemeRepository
import com.keelim.orange.utils.ComponentLogger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import timber.log.Timber


@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
//        KakaoSdk.init(this, TODO())
        Timber.plant(Timber.DebugTree())
    }
}