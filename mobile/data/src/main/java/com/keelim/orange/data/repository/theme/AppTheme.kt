package com.keelim.orange.data.repository.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatDelegate
import com.keelim.orange.data.R

enum class AppTheme(
  val modeNight: Int,
  @DrawableRes val themeIconRes: Int,
  @StringRes val modeNameRes: Int
) {
  FOLLOW_SYSTEM(
    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM,
    R.drawable.ic_baseline_default_theme_24,
    R.string.system
  ),
  DARK(
    AppCompatDelegate.MODE_NIGHT_YES,
    R.drawable.ic_baseline_dark_theme_24,
    R.string.dark_theme
  ),
  LIGHT(
    AppCompatDelegate.MODE_NIGHT_NO,
    R.drawable.ic_baseline_light_theme_24,
    R.string.light_theme
  );

  companion object {
    val THEME_ARRAY = arrayOf(
      FOLLOW_SYSTEM,
      DARK,
      LIGHT
    )
  }
}
