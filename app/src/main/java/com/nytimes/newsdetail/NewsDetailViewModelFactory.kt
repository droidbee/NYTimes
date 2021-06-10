package com.nytimes.newsdetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nytimes.model.Article


/**
 * Simple ViewModel factory that provides the Article and context to the ViewModel.
 */

class NewsDetailsViewModelFactory (
    private val article: Article,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsDetailViewModel::class.java)) {
            return NewsDetailViewModel(article, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}