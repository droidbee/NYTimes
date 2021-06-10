package com.nytimes.model

import javax.inject.Inject


data class NewsResponse(
    val copyright: String,
    val num_results: Int,
    val results: List<Article>,
    val status: String
)