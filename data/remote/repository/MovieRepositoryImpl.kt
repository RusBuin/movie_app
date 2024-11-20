package com.example.myapplication.data.remote.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myapplication.data.local.MovieDao
import com.example.myapplication.data.remote.MovieAPI
import com.example.myapplication.data.remote.dto.MoviePagingSource
import com.example.myapplication.domain.model.Movie
import com.example.myapplication.domain.repositary.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
    private val movieAPI: MovieAPI,
    private val movieDao: MovieDao
): MovieRepository {
    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                Log.d("MovieRepositoryImpl", "Creating MoviePagingSource")
                MoviePagingSource(
                    movieAPI=movieAPI
                )

            }
        ).flow
    }

    override suspend fun upsertItems(movie: Movie) {
        movieDao.upsert(movie)
    }

    override suspend fun deleteItems(movie: Movie) {
        movieDao.delete(movie)
    }

    override fun getItems(): Flow<List<Movie>> {
        return movieDao.getItems()
    }

}