package com.example.kotlin_multiplatform.Article

class ArticleUseCase(private val service: ArticleService) {
    suspend fun getArticle(): List<Article> {
        val articleRaw = service.fetchArticle()
        return mapArticle(articleRaw);
    }

    private fun mapArticle(articleRaw: List<ArticleRaw>): List<Article> =
        articleRaw.map { articleRaw ->
            Article(
                articleRaw.title,
                articleRaw.desc ?: "click to find others",
                articleRaw.date,
                articleRaw.imageUrl
                    ?: "https://media.ediig.com/site/static/img/banner_loanfirst_1.png"
            )
        }
}