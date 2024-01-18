package com.mertkaragul.newsapp.Domain.Repo

import com.mertkaragul.newsapp.Data.remote.dto.NewsDTO

interface NewsRepo {
    suspend fun getTopHeadlines() : NewsDTO
}