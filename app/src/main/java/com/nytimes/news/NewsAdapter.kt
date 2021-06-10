package com.nytimes.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nytimes.model.Article
import com.nytimes.databinding.ListItemNewsBinding

class NewsAdapter(private val onClickListener: OnClickListener): ListAdapter<Article,NewsAdapter.NewsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        return NewsViewHolder(ListItemNewsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        val article = getItem(position)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(article)
        }

        holder.bind(article)
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [Article]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }
    }


    /**
     * The NewsViewHolder constructor takes the binding variable from the associated
     * ListViewItem, which gives it access to the full [Article] information.
     */
    class NewsViewHolder(private var binding: ListItemNewsBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {

            binding.article = article

            if(article.media.isNotEmpty()) {
                if (article.media[0].mediaMetadata.isNotEmpty()) {
                    val imgUrl = article.media[0].mediaMetadata[0].url
                    binding.imgUrl=imgUrl
                }
            }

            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (article: Article) -> Unit) {
        fun onClick(article: Article) = clickListener(article)
    }
}