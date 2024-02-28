package com.example.kotlin_multiplatform.Article

import com.example.kotlin_multiplatform.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticleViewModel : BaseViewModel() {

    private val _articleState: MutableStateFlow<ArticleState> =
        MutableStateFlow(ArticleState(loading = true))

    val articlesState: StateFlow<ArticleState> get() = _articleState

    private val articleUseCase: ArticleUseCase

    init {
        val httpClient = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
        val service = ArticleService(httpClient)
        articleUseCase = ArticleUseCase(service);

        getArticle()
    }

    private fun getArticle() {
        scope.launch {
            delay(1000)
            _articleState.emit(ArticleState(error = "Something went wrong"))
            delay(2000)
            val fetchedArticles = fetchArticles()
            _articleState.emit(ArticleState(articles = fetchedArticles))


        }
    }


    private suspend fun fetchArticles(): List<Article> = articleUseCase.getArticle()


}