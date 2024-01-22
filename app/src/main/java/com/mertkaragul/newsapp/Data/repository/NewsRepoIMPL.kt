package com.mertkaragul.newsapp.Data.repository

import com.mertkaragul.newsapp.Common.Resource
import com.mertkaragul.newsapp.Data.remote.INewsRepo
import com.mertkaragul.newsapp.Data.remote.dto.NewsDTO
import com.mertkaragul.newsapp.Domain.Repo.NewsRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepoIMPL @Inject constructor(
    private val iNewsRepo: INewsRepo
) : NewsRepo {

    override suspend fun getTopHeadlines(): NewsDTO {
        return iNewsRepo.getTopHeadlines()
    }

    override suspend fun getNewsWithCategories(categoryName: String): NewsDTO {
        return iNewsRepo.getNewsWithCategories(category = categoryName)
    }


}