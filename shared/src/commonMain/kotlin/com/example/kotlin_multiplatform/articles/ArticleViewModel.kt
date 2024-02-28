package com.example.kotlin_multiplatform.articles

import com.example.kotlin_multiplatform.BaseViewModel
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

    private fun getArticle() {
        scope.launch {

            val fetchedArticles = useCase.getArticle()
            _articleState.emit(ArticleState(articles = fetchedArticles))


        }
    }


}