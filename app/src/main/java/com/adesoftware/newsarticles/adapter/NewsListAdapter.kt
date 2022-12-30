package com.adesoftware.newsarticles.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adesoftware.newsarticles.databinding.ItemNewsBinding
import com.adesoftware.newsarticles.model.NewsArticle
import com.adesoftware.newsarticles.util.loadImage

class NewsListAdapter: RecyclerView.Adapter<NewsListAdapter.NewsItemViewHolder>() {

    private val newsItems = arrayListOf<NewsArticle>()

    fun onAddNewsItem(item: NewsArticle) {
        newsItems.add(0, item)
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        return NewsItemViewHolder(ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(newsItems[position])
    }

    override fun getItemCount() = newsItems.size

    class NewsItemViewHolder(
        private val binding: ItemNewsBinding
    ): RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.newsImage
        private val author = binding.newsAuthor
        private val title = binding.newsTitle
        private val publishedAt = binding.newsPublishedAt

        fun bind(newsItem: NewsArticle) {
            imageView.loadImage(newsItem.urlToImage)
            author.text = newsItem.author
            title.text = newsItem.title
            publishedAt.text = newsItem.publishedAt
        }
    }
}