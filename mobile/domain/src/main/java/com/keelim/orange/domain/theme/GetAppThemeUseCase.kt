package com.keelim.orange.domain.theme

import com.keelim.orange.data.repository.theme.ThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppThemeUseCase @Inject constructor(
  themeRepository: ThemeRepository
) {
  val appTheme: Flow<Int> = themeRepository.getUserTheme()
}
