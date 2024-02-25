package com.example.kotlin_multiplatform.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin_multiplatform.Article.ArticleViewModel
import com.example.kotlin_multiplatform.Platform

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val articleViewModel: ArticleViewModel by viewModels()

        Platform().logSystemInfo()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    // AboutScreenActivity()
                    //  GreetingView("Hello")
                    ArticleListActivity(
                        onAboutButtonClick = { /*TODO*/ },
                        articlesViewModel = articleViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        //  GreetingView("Hello, Android!")
        AboutScreenActivity()
        //  ArticleListActivity(onAboutButtonClick = { /*TODO*/ }, articlesViewModel =articleViewModel)

    }
}
