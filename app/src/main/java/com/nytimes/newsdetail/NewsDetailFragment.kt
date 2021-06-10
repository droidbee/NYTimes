package com.nytimes.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.nytimes.R
import com.nytimes.databinding.FragmentNewsDetailBinding
import com.nytimes.news.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint


class NewsDetailFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentNewsDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val article = NewsDetailFragmentArgs.fromBundle(requireArguments()).selectedArticle

        val viewModelFactory=NewsDetailsViewModelFactory(article, application)
        binding.viewModel=ViewModelProvider(
            this,viewModelFactory).get(NewsDetailViewModel::class.java)
        return binding.root
    }


}