package com.mertkaragul.newsapp.Data.remote.dto

data class NewsDTO(
    val article: List<ArticleDTO>,
    val status: String,
    val totalResults: Int
)