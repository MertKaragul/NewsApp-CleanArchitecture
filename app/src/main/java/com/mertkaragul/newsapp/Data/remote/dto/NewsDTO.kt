package com.mertkaragul.newsapp.Data.remote.dto

import com.mertkaragul.newsapp.Domain.Model.NewsModel

data class NewsDTO(
    val articles: List<ArticleDTO>,
    val status: String,
    val totalResults: Int
)



fun NewsDTO.convertNewsModel() : NewsModel {
    return NewsModel(this.articles.map { it.toArticleModel() })
}