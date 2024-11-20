package com.example.myapplication.data.remote

import android.graphics.Movie
import retrofit2.http.Query
import com.example.myapplication.data.remote.dto.MovieResponse
import com.example.myapplication.presentation.onboarding.Page
import com.example.myapplication.util.Constants.API_KEY
import retrofit2.http.GET

interface MovieAPI {

    @GET("movie/popular")
    suspend fun getAllMovies(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY,
    ) : MovieResponse
}