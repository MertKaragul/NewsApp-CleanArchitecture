package com.mertkaragul.newsapp.Common

sealed class Screen(val route : String) {
    data object NewsScreen : Screen("news_screen")
    data object NewsDetail : Screen("news_detail")
}