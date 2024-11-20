package com.example.myapplication.domain.usecases.movies


import com.example.myapplication.data.local.MovieDao
import com.example.myapplication.domain.model.Movie

import kotlinx.coroutines.flow.Flow

class GetItems(
    private val movieDao: MovieDao
) {

    operator fun invoke(): Flow<List<Movie>>{
        return movieDao.getItems()
    }

}