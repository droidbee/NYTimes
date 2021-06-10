package com.nytimes.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nytimes.model.Article
import com.nytimes.network.NewsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor():ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _articles=MutableLiveData<List<Article>>()
    val articles:LiveData<List<Article>>
        get()= _articles

    private val _navigateToDetail=MutableLiveData<Article>()
    val navigateToDetail:LiveData<Article>
        get() = _navigateToDetail

    /**
     * Call getNews() on init so we can display articles immediately.
     */
    init {
        getNews()
    }

    /**
     * Sets the value to the articles
     */
     fun getNews() {
        viewModelScope.launch {
            try {
                val newsResponse = NewsApi.retrofitService.getNews()
                _articles.value=newsResponse.results
                _status.value=newsResponse.status

            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }


    fun displayArticleDetails(article: Article){
        _navigateToDetail.value=article
    }

    fun displayArticleDetailsComplete(){
        _navigateToDetail.value=null
    }
}