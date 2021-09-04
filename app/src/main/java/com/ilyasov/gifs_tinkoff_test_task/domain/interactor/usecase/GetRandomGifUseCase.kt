package com.ilyasov.gifs_tinkoff_test_task.domain.interactor.usecase

import com.ilyasov.gifs_tinkoff_test_task.data.db.repository.RemoteRepository
import com.ilyasov.gifs_tinkoff_test_task.domain.entity.GifEntity
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetRandomGifUseCase @Inject constructor(
    private val repo: RemoteRepository
) {
    suspend fun execute(json: Boolean = true): Response<GifEntity> = repo.getRandomGif(json)
}