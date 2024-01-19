package com.mertkaragul.newsapp.Presentation.News

import com.mertkaragul.newsapp.Domain.Model.ArticleModel
import com.mertkaragul.newsapp.Domain.Model.NewsModel

data class NewsState(
    val isLoading : Boolean = false,
    val news : List<ArticleModel> = emptyList(),
    val error : String? = "",
)