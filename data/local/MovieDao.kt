package com.example.myapplication.data.local

import androidx.room.*
import com.example.myapplication.domain.model.Result
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(result: Result)

    @Delete
    suspend fun delete(result: Result)

    @Query("SELECT * FROM Result")
    suspend fun getMovies(): Flow<List<Result>>
}