package com.adesoftware.newsarticles.model

import com.adesoftware.newsarticles.util.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository {
    private val newsService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsService::class.java)

    fun getNewsArticles(): Flow<NewsArticle> {
        return flow {
            val newSource = newsService.getNews()
            newSource.forEach {
                emit(it)
                delay(Constants.NEWS_DELAY)
            }
        }
    }
}