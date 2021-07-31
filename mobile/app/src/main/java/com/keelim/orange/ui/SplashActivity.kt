package com.keelim.orange.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.keelim.orange.databinding.ActivitySplashBinding
import com.keelim.orange.ui.auth.AuthActivity
import com.keelim.orange.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity:AppCompatActivity() {
    private val binding by lazy{ ActivitySplashBinding.inflate(layoutInflater)}
    private val scope= MainScope()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        scope.launch {
            delay(3000)
            startActivity(Intent(this@SplashActivity, AuthActivity::class.java))
            finish()
        }
    }
}