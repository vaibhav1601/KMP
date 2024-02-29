package com.example.kotlin_multiplatform.articles

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticleUseCase(private val repo: ArticleRepository) {
    suspend fun getArticle(fetchArticle: Boolean): List<Article> {
        val articleRaw = repo.getArticles(fetchArticle)
        return mapArticle(articleRaw);
    }

    private fun mapArticle(articleRaw: List<ArticleRaw>): List<Article> =
        articleRaw.map { articleRaw ->
            Article(
                articleRaw.title,
                articleRaw.desc ?: "click to find others",
                getDaysToString(articleRaw.date),
                articleRaw.imageUrl
                    ?: "https://media.ediig.com/site/static/img/banner_loanfirst_1.png"
            )
        }

    private fun getDaysToString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "yesterday"
            else -> "Today"
        }

        return result
    }
}