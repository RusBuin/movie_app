package com.example.myapplication.domain.repositary

import androidx.paging.PagingData
import com.example.myapplication.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
      fun getMovies(): Flow<PagingData<Movie>>
      suspend fun upsertItems(movie: Movie)

      suspend fun deleteItems(movie: Movie)

      fun getItems(): Flow<List<Movie>>
}