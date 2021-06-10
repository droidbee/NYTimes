package com.nytimes.newsdetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nytimes.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class NewsDetailViewModel (article: Article, app:Application): AndroidViewModel(app) {

    private val _selectedArticle=MutableLiveData<Article>()
    val selectedArticle:LiveData<Article>
        get()=_selectedArticle



    init {
        _selectedArticle.value=article

    }
}