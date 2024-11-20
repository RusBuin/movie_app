package com.example.myapplication.di

import com.example.myapplication.domain.usecases.app_entry.SaveAppEntry
import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.local.MovieDao
import com.example.myapplication.data.local.MovieDatabase
import com.example.myapplication.data.manager.LocalUserManagerImpl
import com.example.myapplication.data.remote.MovieAPI
import com.example.myapplication.data.remote.repository.MovieRepositoryImpl
import com.example.myapplication.domain.manager.LocalUserManager
import com.example.myapplication.domain.repositary.MovieRepository
import com.example.myapplication.domain.usecases.app_entry.AppEntryUseCases
import com.example.myapplication.domain.usecases.app_entry.ReadAppEntry
import com.example.myapplication.domain.usecases.movies.GetMovies
import com.example.myapplication.domain.usecases.movies.MoviesUseCases
import com.example.myapplication.util.Constants.BASE_URL
import com.example.myapplication.util.Constants.MOVIES_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


    @Provides
    @Singleton
    fun provideMovieApi(): MovieAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }


    @Provides
    @Singleton
    fun provideMoviesRepository(
        movieAPI: MovieAPI
    ): MovieRepository = MovieRepositoryImpl(movieAPI)


    @Provides
    @Singleton
    fun provideMoviesUseCases(
        movieRepository: MovieRepository
    ): MoviesUseCases {
        return MoviesUseCases(
            getMovies = GetMovies(movieRepository)
        )
    }

    @Provides
    @Singleton
    fun provideMovieDatabase(application: Application): MovieDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = MovieDatabase::class.java,
            name = MOVIES_DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.movieDao
}

