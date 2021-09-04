package com.ilyasov.gifs_tinkoff_test_task.domain.entity

import com.google.gson.annotations.SerializedName

class GifResponse(
    @SerializedName("result")
    val gifs: List<GifEntity>,
    @SerializedName("totalCount")
    val totalCount: Long
)