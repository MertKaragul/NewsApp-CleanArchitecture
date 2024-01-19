package com.mertkaragul.newsapp.Presentation.News.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mertkaragul.newsapp.Domain.Model.ArticleModel
import com.mertkaragul.newsapp.Domain.Model.NewsModel

@Composable
fun NewsItem(
    articleModel: ArticleModel
) {
    Text(
        articleModel.title,
        color = Color.Black
    )
}