package com.example.kotlin_multiplatform.android.di

import com.example.kotlin_multiplatform.articles.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ArticleViewModel(get()) }
}