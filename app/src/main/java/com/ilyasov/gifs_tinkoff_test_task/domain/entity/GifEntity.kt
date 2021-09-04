package com.ilyasov.gifs_tinkoff_test_task.domain.entity

import com.google.gson.annotations.SerializedName

class GifEntity(
    @SerializedName("id")
    val id: Long,
    @SerializedName("description")
    val description: String,
    @SerializedName("votes")
    val numVotes: Long,
    @SerializedName("author")
    val author: String,
    @SerializedName("date")
    val publicationDate: String,
    @SerializedName("gifURL")
    val gifURL: String,
    @SerializedName("gifSize")
    val gifSize: Long,
    @SerializedName("previewURL")
    val previewURL: String,
    @SerializedName("videoURL")
    val videoURL: String,
    @SerializedName("videoPath")
    val videoPath: String,
    @SerializedName("videoSize")
    val videoSize: Long,
    @SerializedName("type")
    val contentType: String,
    @SerializedName("width")
    val width: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("commentsCount")
    val numComments: Long,
    @SerializedName("fileSize")
    val fileSize: Long,
    @SerializedName("canVote")
    val canVote: Boolean
)