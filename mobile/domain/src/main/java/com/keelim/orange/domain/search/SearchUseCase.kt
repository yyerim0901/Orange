package com.keelim.orange.domain.search

import com.keelim.orange.data.model.Search
import com.keelim.orange.data.repository.search.SearchRepository

class SearchUseCase(
    private val searchRepository: SearchRepository,
) {
    suspend fun search(query: String): List<Search> {
        return emptyList()
    }
}