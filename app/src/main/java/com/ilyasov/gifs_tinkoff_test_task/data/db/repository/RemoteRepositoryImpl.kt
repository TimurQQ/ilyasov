package com.ilyasov.gifs_tinkoff_test_task.data.db.repository

import com.ilyasov.gifs_tinkoff_test_task.data.db.remote.api.APIInterface
import com.ilyasov.gifs_tinkoff_test_task.domain.entity.GifResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val gifsAPI: APIInterface
) : RemoteRepository {
    override suspend fun getGifs(
        section: String,
        page: Long,
        json: Boolean
    ): Response<GifResponse> = gifsAPI.getGifs(section, page)
}