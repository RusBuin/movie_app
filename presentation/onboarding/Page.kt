package com.example.myapplication.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.myapplication.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Discover New Movies",
        description = "Explore the latest releases, top-rated films, and hidden gems across all genres.",
        image =
        R.drawable.p1
    ),
    Page(
        title = "Create Your Watchlist",
        description = "Save movies to your personal watchlist so you never forget what to watch next.",
        image = R.drawable.p6
    ),
    Page(
        title = "Get Recommendations",
        description = "Receive personalized movie recommendations based on your tastes.",
        image = R.drawable.p4
    )
)
