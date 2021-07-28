package com.keelim.orange.domain.theme

import com.keelim.orange.data.repository.theme.ThemeRepository
import javax.inject.Inject


class SetAppThemeUseCase @Inject constructor(
    private val themeRepository: ThemeRepository
) {

    suspend operator fun invoke(theme: Int) = themeRepository.setUserTheme(theme)
}
