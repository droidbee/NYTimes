package com.nytimes.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nytimes.R
import com.nytimes.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment:Fragment() {

    /**
     * Lazily initialize our [NewsViewModel].
     */
//    private val viewModel: NewsViewModel by lazy {
//        ViewModelProvider(this).get(NewsViewModel::class.java)
//    }


    // Injecting viewModel using Dependency Injection
    private val viewModel:NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentNewsBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        binding.viewModel=viewModel
        binding.recyclerviewNews.adapter=NewsAdapter(NewsAdapter.OnClickListener{
            viewModel.displayArticleDetails(it)
        })

        viewModel.navigateToDetail.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(
                        NewsFragmentDirections.actionNewsFragmentToNewsDetailFragment(it))
                viewModel.displayArticleDetailsComplete()
            }
        })
        return binding.root

    }
}