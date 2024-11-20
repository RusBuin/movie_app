package com.example.myapplication.domain.usecases.movies

import androidx.paging.PagingData
import com.example.myapplication.domain.model.Result
import com.example.myapplication.domain.repositary.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovies (
    private val movieRepository: MovieRepository
){

    operator fun invoke(): Flow<PagingData<Result>> {

    return movieRepository.getMovies()
    }
}
