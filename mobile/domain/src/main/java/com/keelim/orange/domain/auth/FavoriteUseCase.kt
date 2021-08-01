package com.keelim.orange.domain.auth

import com.keelim.orange.data.model.Favorite

class FavoriteUseCase(

) {
    suspend operator fun invoke():List<Favorite>{
        return emptyList()
    }
}