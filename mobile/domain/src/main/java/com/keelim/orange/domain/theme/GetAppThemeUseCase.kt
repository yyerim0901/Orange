package com.keelim.orange.domain.theme

import com.keelim.orange.data.repository.theme.ThemeRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetAppThemeUseCase @Inject constructor(
    themeRepository: ThemeRepository
) {
    val appTheme: Flow<Int> = themeRepository.getUserTheme()
}
