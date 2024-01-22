package com.mertkaragul.newsapp.Presentation.News.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mertkaragul.newsapp.Domain.Model.ArticleModel
import com.mertkaragul.newsapp.Domain.Model.NewsModel

@Composable
fun NewsItem(
    articleModel: ArticleModel,
    onItemClick : (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        AsyncImage(
            model = articleModel.urlToImage,
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            articleModel.title,
            color = Color.Black,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W600,
            fontSize = 16.sp
        )

        Button(
            onClick = { onItemClick(articleModel.url) },
            modifier = Modifier.fillMaxWidth()) {
            Text("Detaylar")
        }
    }
}