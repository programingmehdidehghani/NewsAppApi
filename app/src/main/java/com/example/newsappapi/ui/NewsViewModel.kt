package com.example.newsappapi.ui

import androidx.lifecycle.ViewModel
import com.example.newsappapi.repository.NewsRepository


class NewsViewModel(
    val newsRepository : NewsRepository
) : ViewModel() {
}