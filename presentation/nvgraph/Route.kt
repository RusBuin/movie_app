package com.example.myapplication.presentation.nvgraph

sealed class Route (
    val route: String
){
    object OnBoardingScreen : Route("OnBoardingScreen")
    object HomeScreen : Route("homeScreen")
    object SearchScreen : Route("searchScreen")
    object BookMarkScreen : Route("bookmarkScreen")
    object DetailsScreen : Route("detailsScreen")
    object AppStartNavigation : Route("appStartNavigation")
    object Navigation: Route("navigation")
    object NavigationScreen : Route("navigationScreen")
}