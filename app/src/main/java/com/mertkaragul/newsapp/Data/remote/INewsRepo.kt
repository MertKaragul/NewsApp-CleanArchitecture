package com.mertkaragul.newsapp.Data.remote

import com.mertkaragul.newsapp.Common.Constants
import com.mertkaragul.newsapp.Data.remote.dto.NewsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface INewsRepo {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country : String = Constants.COUNTRY,
        @Query("apiKey") apiKey : String = Constants.API_KEY
    ) : NewsDTO
}