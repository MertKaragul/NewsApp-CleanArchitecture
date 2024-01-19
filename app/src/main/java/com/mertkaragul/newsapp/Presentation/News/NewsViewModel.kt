package com.mertkaragul.newsapp.Presentation.News

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mertkaragul.newsapp.Common.Resource
import com.mertkaragul.newsapp.Data.remote.dto.convertNewsModel
import com.mertkaragul.newsapp.Data.remote.dto.toArticleModel
import com.mertkaragul.newsapp.Domain.UseCase.getNews.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel(){
    private val _state = mutableStateOf(NewsState())
    val state = _state

    init {
        viewModelScope.launch {
            getNews()
        }
    }

    private suspend fun getNews(){
        getNewsUseCase.executeGetNews().onEach { it ->
            when(it){
                is Resource.Success -> {
                    if (it.data == null){
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = "News cannot be get, please try again"
                        )
                    }else{
                        _state.value = _state.value.copy(
                            isLoading = false,
                            news = it.data.articles.map { it.toArticleModel() }
                        )
                    }
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = it.message ?: "Something went wrong"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }




}