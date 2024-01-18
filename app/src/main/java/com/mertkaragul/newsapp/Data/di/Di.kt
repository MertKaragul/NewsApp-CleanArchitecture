package com.mertkaragul.newsapp.Data.di

import com.mertkaragul.newsapp.Common.Constants
import com.mertkaragul.newsapp.Data.remote.INewsRepo
import com.mertkaragul.newsapp.Data.repository.NewsRepoIMPL
import com.mertkaragul.newsapp.Domain.Repo.NewsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Di {

    @Provides
    @Singleton
    fun provideNewsApi() = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(INewsRepo::class.java)


    @Provides
    @Singleton
    fun provideNewsImpl(iNewsRepo: INewsRepo) : NewsRepo {
        return NewsRepoIMPL(iNewsRepo)
    }
}