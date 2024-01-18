package com.mertkaragul.newsapp.Domain.Model

import com.mertkaragul.newsapp.Data.remote.dto.ArticleDTO

data class NewsModel(
    val articleDTOS : List<ArticleDTO>
)