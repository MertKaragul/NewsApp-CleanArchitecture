package com.mertkaragul.newsapp.Data.remote.dto

data class ArticleDTO(
    val author: String,
    val content: Any,
    val description: Any,
    val publishedAt: String,
    val source: SourceDTO,
    val title: String,
    val url: String,
    val urlToImage: Any
)