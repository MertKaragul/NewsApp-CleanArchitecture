package com.mertkaragul.newsapp.Presentation.News.views

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mertkaragul.newsapp.Common.Constants
import com.mertkaragul.newsapp.Common.Resource
import com.mertkaragul.newsapp.Presentation.News.NewsEvent
import com.mertkaragul.newsapp.Presentation.News.NewsState
import com.mertkaragul.newsapp.Presentation.News.NewsViewModel

@Composable
fun NewsView(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val state = newsViewModel.state.value
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

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
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Categories{
                newsViewModel.onEvent(NewsEvent.GetNewsByCategories(it))
            }


            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.news){
                    NewsItem(it){link ->
                        uriHandler.openUri(link)
                    }
                }
            }
        }
    }
}