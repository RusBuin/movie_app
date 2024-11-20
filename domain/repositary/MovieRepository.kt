package com.example.myapplication.domain.repositary

import android.graphics.Movie
import androidx.paging.DataSource
import androidx.paging.PagingData
import com.example.myapplication.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
      fun getMovies(): Flow<PagingData<Result>>
}