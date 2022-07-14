package com.example.newsappapi.repository

import androidx.room.Query
import com.example.newsappapi.api.RetrofitInstance
import com.example.newsappapi.db.ArticleDatabase

class NewsRepository(
    val db : ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode : String , pageNumber : Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery : String ,pageNumber: Int ) =
        RetrofitInstance.api.getSearchForNews(searchQuery,pageNumber)
}