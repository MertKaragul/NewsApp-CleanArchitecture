package com.mertkaragul.newsapp.Data.remote.dto

import com.mertkaragul.newsapp.Domain.Model.ArticleModel

data class ArticleDTO(
    val source: SourceDTO,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
)


fun ArticleDTO.toArticleModel() : ArticleModel{
    return ArticleModel(this.title ?: "null",this.description ?: "",this.author?: "null",this.urlToImage?: "null",this.url?: "null")
}