package com.mertkaragul.newsapp.Presentation.News.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.mertkaragul.newsapp.Common.Resource
import com.mertkaragul.newsapp.Presentation.News.NewsState
import com.mertkaragul.newsapp.Presentation.News.NewsViewModel

@Composable
fun NewsView(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val state = newsViewModel.state.value

    if(state.isLoading){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }else if(!state.error.isNullOrEmpty()){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(state.error)
        }
    }else{
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.news){
                NewsItem(it)
            }
        }
    }
}