package com.example.myapplication.data.remote.dto

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myapplication.data.remote.MovieAPI
import com.example.myapplication.domain.model.Movie
import com.example.myapplication.util.Constants.API_KEY

class MoviePagingSource(
    private val movieAPI: MovieAPI
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private var totalMovieCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1
        Log.d(
            "MoviePagingSource",
            "Loading page: $page (Initial Load: ${params.key == null}), Load size: ${params.loadSize}, Params: $params"
        )
        return try {
            val movieResponse = movieAPI.getMovies(page = page, apiKey = API_KEY)
            Log.d("MoviePagingSource", "Response from API: ${movieResponse.results.size} movies")
            totalMovieCount += movieResponse.results.size

            val movies = movieResponse.results.distinctBy { it.title }  // Убираем дубликаты
            Log.d("MoviePagingSource", "Filtered results count: ${movies.size}")

            LoadResult.Page(
                data = movies,
                nextKey = if (totalMovieCount == movieResponse.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("MoviePagingSource", "Error loading movies", e)
            LoadResult.Error(throwable = e)
        }
    }
}
