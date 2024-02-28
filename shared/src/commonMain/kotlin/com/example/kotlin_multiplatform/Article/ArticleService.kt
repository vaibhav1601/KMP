package com.example.kotlin_multiplatform.Article

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient:HttpClient) {
    private val country="us"
    private val category="business"
    private val apiKey="891583aad66a4e4ba8a3e34c3cd34bb8"

    suspend fun fetchArticle():List<ArticleRaw>{
        val response:ArticleResponse=httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.article

    }
}