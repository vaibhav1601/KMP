package com.example.kotlin_multiplatform.Article

data class ArticleState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null

)

