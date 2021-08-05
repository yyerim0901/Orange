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
        apiRequestFactory.retrofit.sue().body()
        return@withContext false
    }

    override suspend fun like(): Boolean = withContext(dispatcher){
        apiRequestFactory.retrofit.like().body()
        return@withContext false
    }

    override suspend fun share(): Boolean = withContext(dispatcher) {
        apiRequestFactory.retrofit.share().body()
        return@withContext false
    }

    override suspend fun authenticate(): Boolean  = withContext(dispatcher){
        apiRequestFactory.retrofit.share().body()
        return@withContext false
    }
}