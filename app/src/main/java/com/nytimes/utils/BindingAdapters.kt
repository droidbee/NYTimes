package com.nytimes.utils

import android.webkit.WebView
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nytimes.R
import com.nytimes.model.Article
import com.nytimes.news.NewsAdapter

/**
 * Binding Articles to Recyclerview
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Article>?) {
    val adapter = recyclerView.adapter as NewsAdapter
    adapter.submitList(data)
}

/**
 * Uses the Glide library to load an image by URL into an [ImageView]
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background))
            .into(imgView)
        //Glide.with(imgView.context).load(imgUrl).into(imgView)
    }

    /**
     * Used to load the url in webview
     */
    @BindingAdapter("loadUrl")
    fun WebView.setUrl(url: String) {
        this.loadUrl(url)
    }
}