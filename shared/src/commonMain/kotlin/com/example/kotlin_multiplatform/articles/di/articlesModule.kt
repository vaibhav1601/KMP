package com.example.kotlin_multiplatform.articles.di

import com.example.kotlin_multiplatform.articles.ArticleService
import com.example.kotlin_multiplatform.articles.ArticleUseCase
import com.example.kotlin_multiplatform.articles.ArticleViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticleService> {
        ArticleService(get())
    }
    single<ArticleUseCase> {
        ArticleUseCase(get())
    }
    single<ArticleViewModel> {
        ArticleViewModel(get())
    }

}