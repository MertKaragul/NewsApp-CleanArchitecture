package com.mertkaragul.newsapp.Presentation.News.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mertkaragul.newsapp.Common.Constants
import com.mertkaragul.newsapp.Presentation.News.NewsEvent

@Composable
fun Categories(
    onItemClick : (String) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        items(Constants.categories.size){
            Button(onClick = {
                onItemClick(Constants.categories[it].first)
            },
                modifier = Modifier.padding(5.dp)) {
                Text(Constants.categories[it].second)
            }
        }
    }
}