package com.example.kotlin_multiplatform.articles

import com.example.kotlin_multiplatform.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val useCase: ArticleUseCase
) : BaseViewModel() {

    private val _articleState: MutableStateFlow<ArticleState> =
        MutableStateFlow(ArticleState(loading = true))

    val articlesState: StateFlow<ArticleState> get() = _articleState

    init {
        getArticle()
    }

     fun getArticle(fetchArticle: Boolean=false) {
        scope.launch {
            _articleState.emit(ArticleState(loading = true, articles = _articleState.value.articles))

            val fetchedArticles = useCase.getArticle(fetchArticle)
            _articleState.emit(ArticleState(articles = fetchedArticles))


        }
    }


}