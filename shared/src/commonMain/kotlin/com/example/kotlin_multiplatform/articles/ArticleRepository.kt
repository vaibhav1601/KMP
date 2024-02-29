package com.example.kotlin_multiplatform.articles

class ArticleRepository(
    private val articleDataSource: ArticleDataSource,
    private val service: ArticleService
) {


    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {

        if (forceFetch) {
            articleDataSource.clearArticle()
            return fetchArticle()
        }
        val articleDB = articleDataSource.getAllArticle()
        println("Got ${articleDB.size} from database!!!")

        if (articleDB.isEmpty()) {
            return fetchArticle()
        }

        return articleDB;
    }

    private suspend fun fetchArticle(): List<ArticleRaw> {
        val fetchArticle = service.fetchArticle()
        articleDataSource.insertArticle(fetchArticle)
        return fetchArticle
    }
}