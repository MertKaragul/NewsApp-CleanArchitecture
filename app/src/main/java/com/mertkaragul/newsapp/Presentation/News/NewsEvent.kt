package com.mertkaragul.newsapp.Presentation.News

sealed class NewsEvent {
    data class GetNewsByCategories(val category : String): NewsEvent()
}