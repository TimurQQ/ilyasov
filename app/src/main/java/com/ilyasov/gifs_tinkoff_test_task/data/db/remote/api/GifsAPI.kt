package com.ilyasov.gifs_tinkoff_test_task.data.db.remote.api

import com.ilyasov.gifs_tinkoff_test_task.domain.entity.GifResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GifsAPI : APIInterface {

    companion object {
        const val GET_GIFS = "/{section}/{page}"
        const val SET_JSON_PARAMETER = "json"
        const val SET_SECTION = "section"
        const val SET_PAGE = "page"
    }

    @GET(GET_GIFS)
    override suspend fun getGifs(
        @Path(SET_SECTION) section: String,
        @Path(SET_PAGE) page: Long,
        @Query(SET_JSON_PARAMETER) json: Boolean
    ): Response<GifResponse>
}