package com.keelim.orange.ui.main

import com.keelim.orange.utils.MaterialDialog.Companion.negativeButton
import com.keelim.orange.utils.MaterialDialog.Companion.positiveButton
import com.keelim.orange.utils.MaterialDialog.Companion.singleChoiceItems
import com.keelim.orange.utils.MaterialDialog.Companion.title
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.keelim.orange.R
import com.keelim.orange.data.repository.theme.AppTheme
import com.keelim.orange.databinding.ActivityMainBinding
import com.keelim.orange.utils.MaterialDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.navView.setupWithNavController(navController())
    }

    private fun navController() = findNavController(R.id.nav_host_fragment_activity_main)

    private fun chooseThemeClick() {
        val currentTheme = mainViewModel.theme.value
        var checkedItem = AppTheme.THEME_ARRAY.indexOfFirst { it.modeNight == currentTheme }
        if (checkedItem >= 0) {
            val items = AppTheme.THEME_ARRAY.map {
                getText(it.modeNameRes)
            }.toTypedArray()

            MaterialDialog.createDialog(this) {
                title("테마 선택")
                singleChoiceItems(items, checkedItem) {
                    checkedItem = it
                }
                positiveButton("확인") {
                    val mode = AppTheme.THEME_ARRAY[checkedItem].modeNight
                    AppCompatDelegate.setDefaultNightMode(mode)
                    mainViewModel.setAppTheme(mode)
                    // Update theme description TextView
//                    binding.themeDescription.text = getString(AppTheme.THEME_ARRAY[checkedItem].modeNameRes)
                }
                negativeButton("취소")
            }.show()
        }
    }
}