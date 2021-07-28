package com.keelim.orange.data.repository.theme

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.keelim.orange.data.repository.theme.ThemeRepository.PreferencesKeys.USER_THEME
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


class ThemeRepository @Inject constructor(
    @ApplicationContext val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = STORE_NAME)

    fun getUserTheme() = context.dataStore.data.map { preferences ->
        preferences[USER_THEME] ?: AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    }

    suspend fun setUserTheme(theme: Int) {
        context.dataStore.edit { preferences ->
            preferences[USER_THEME] = theme
        }
    }

    private object PreferencesKeys {
        val USER_THEME = intPreferencesKey(USER_THEME_KEY)
    }

    companion object {
        const val STORE_NAME = "preferences"
        private const val USER_THEME_KEY = "user_theme"
    }
}
