package com.example.kotlin_multiplatform.articles

import com.example.kotlin_multiplatform.db.ArticleDB

class ArticleDataSource(private val database: ArticleDB) {

     fun getAllArticle(): List<ArticleRaw> =
        database.articleDatabaseQueries.selectAllArticle(::mapToArticleRow).executeAsList()

     fun insertArticle(article: List<ArticleRaw>) {
        database.articleDatabaseQueries.transaction {
            article.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticle() {
        database.articleDatabaseQueries.removeAllArticle()
    }

    private fun insertArticle(article: ArticleRaw) {
        database.articleDatabaseQueries.insertArticle(
            article.title,
            article.desc,
            article.date,
            article.imageUrl
        )
    }

    private fun mapToArticleRow(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ): ArticleRaw = ArticleRaw(
        title,
        desc,
        date,
        url
    )
}