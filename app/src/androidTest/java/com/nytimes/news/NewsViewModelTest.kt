package com.nytimes.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nytimes.utils.getOrAwaitValue
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NewsViewModelTest : TestCase(){

    private lateinit var viewModel: NewsViewModel

    @get:Rule
    val instantTaskExecutorRule=InstantTaskExecutorRule()

    @Before
    override fun setUp() {
        super.setUp()
        viewModel= NewsViewModel()
    }

    @Test
    fun testNewsViewModelgetNews()= runBlocking{
        viewModel.getNews()
        val status = viewModel.status.getOrAwaitValue()
        assertEquals("OK",status)
    }
}