package com.example.newsappapi.repository

import com.example.newsappapi.api.RetrofitInstance
import com.example.newsappapi.db.ArticleDatabase

class NewsRepository(
    val db : ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode : String , pageNumber : Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)
}