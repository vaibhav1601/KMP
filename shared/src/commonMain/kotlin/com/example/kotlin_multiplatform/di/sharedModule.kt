package com.example.kotlin_multiplatform.di

import com.example.kotlin_multiplatform.articles.di.articlesModule

val sharedModule = listOf(
    articlesModule,
    networkModule
)
