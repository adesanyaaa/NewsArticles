package com.adesoftware.newsarticles.model

import com.adesoftware.newsarticles.util.Constants
import retrofit2.http.GET

interface NewsService {
    @GET(Constants.END_POINTS)
    suspend fun getNews(): List<NewsArticle>
}