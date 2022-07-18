package com.example.newsappapi.models

import com.example.newsappapi.models.Article

data class NewsResponse(
    val articles : MutableList<Article>,
    val status : String,
    val totalResults : Int
)
