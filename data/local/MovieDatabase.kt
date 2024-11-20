package com.example.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Result::class], version = 1)

abstract class MovieDatabase: RoomDatabase() {
    abstract val movieDao: MovieDao
}