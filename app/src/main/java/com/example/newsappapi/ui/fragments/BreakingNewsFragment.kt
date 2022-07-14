package com.example.newsappapi.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappapi.R
import com.example.newsappapi.adapters.NewsAdapter
import com.example.newsappapi.db.ArticleDatabase
import com.example.newsappapi.repository.NewsRepository
import com.example.newsappapi.ui.NewsActivity
import com.example.newsappapi.ui.NewsViewModel
import com.example.newsappapi.ui.NewsViewModelProviderFactory
import com.example.newsappapi.utils.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    private lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    val TAG = "BreakingNewsFragment"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsRepository = NewsRepository(ArticleDatabase(view.context))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        setupRecyclerView()
        viewModel.breakingNews.observe(viewLifecycleOwner , Observer { response ->
             when(response){
                 is Resource.Success -> {
                     hideProgressBar()
                     response.data?.let { newsResponse ->
                         newsAdapter.differ.submitList(newsResponse.articles)
                     }
                 }
                 is Resource.Error -> {
                     hideProgressBar()
                     response.message?.let { message ->
                         Log.e(TAG, "An error occured: $message")

                     }
                 }
                 is Resource.Loading -> {
                     showProgressBar()
                 }
             }
        })
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}