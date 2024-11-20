package com.example.myapplication.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class Result(
    @PrimaryKey val id: Int,
    @SerializedName("poster_path") val poster: String,
    val title: String,
    val overview: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("original_language") val originalLangauge: String
)