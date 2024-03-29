package com.mertkaragul.newsapp.Domain.UseCase.getNews


import com.mertkaragul.newsapp.Common.Resource
import com.mertkaragul.newsapp.Data.remote.dto.NewsDTO
import com.mertkaragul.newsapp.Domain.Repo.NewsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val newsRepo: NewsRepo) {
    fun executeGetNews() : Flow<Resource<NewsDTO>> = flow {
        emit(Resource.Loading())

        val newsDTO = newsRepo.getTopHeadlines()

        // Null kontrolü ekleyin
        if (newsDTO != null) {
            emit(Resource.Success(newsDTO))
        } else {
            emit(Resource.Error("News data is null"))
        }
    }.catch {
        emit(Resource.Error(it.localizedMessage ?: "Something went wrong"))
    }



    fun executeGetNewsWithCategories(categoryName : String) : Flow<Resource<NewsDTO>> = flow<Resource<NewsDTO>> {
        emit(Resource.Loading())

        val news = newsRepo.getNewsWithCategories(categoryName)
        if (news != null) {
            emit(Resource.Success(news))
        } else {
            emit(Resource.Error("News data is null"))
        }
    }.catch {
        emit(Resource.Error(it.localizedMessage ?: "Something went wrong"))
    }
}