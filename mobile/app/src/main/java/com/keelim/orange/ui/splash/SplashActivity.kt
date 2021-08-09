package com.keelim.orange.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.keelim.orange.databinding.ActivitySplashBinding
import com.keelim.orange.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observeData()
    }

    private fun observeData() {
        lifecycleScope.launchWhenCreated {
            viewModel.loading
                .collect {
                    if (it) {
                        goNext()
                    }
                }
        }
    }

    private fun goNext() {
        val pref = getSharedPreferences("checkFirst", MODE_PRIVATE)
        val checkFirst = pref.getBoolean("checkFirst", false)
        if (!checkFirst) {
            val editor = pref.edit().apply {
                putBoolean("checkFirst", true)
                apply()
            }
            startActivity(Intent(this, TutorialActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}