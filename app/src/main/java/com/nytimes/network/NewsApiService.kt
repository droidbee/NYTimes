package com.nytimes.network

import com.nytimes.model.NewsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://api.nytimes.com/"
private const val API_KEY="QDYAmDFmPQz3nh8gUFGcDojp9j4y95mH"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface NewsApiService {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/1.json")
    suspend fun getNews(
        @Query("api-key")
        apiKey:String= API_KEY)
    : NewsResponse
}

object NewsApi {
    val retrofitService : NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
}