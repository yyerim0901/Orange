package com.keelim.orange.data.repository.season.other

import com.keelim.orange.data.api.ApiRequestFactory
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class OtherRepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val apiRequestFactory: ApiRequestFactory,
) : OtherRepository {
    override suspend fun sue(): Boolean = withContext(dispatcher) {
        apiRequestFactory.retrofit.sue().isExecuted
    }

    override suspend fun like(): Boolean = withContext(dispatcher){
        apiRequestFactory.retrofit.like().isExecuted
    }

    override suspend fun share(): Boolean = withContext(dispatcher) {
        apiRequestFactory.retrofit.share().isExecuted
    }

    override suspend fun authenticate(): Boolean  = withContext(dispatcher){
        apiRequestFactory.retrofit.share().isExecuted
    }
}