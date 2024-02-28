package com.example.kotlin_multiplatform.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_multiplatform.android.UI.AboutScreenActivity
import com.example.kotlin_multiplatform.android.UI.ArticleListActivity


@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )

    }

}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLES.root,
        modifier = modifier,
    ) {
        composable(Screen.ARTICLES.root) {
            ArticleListActivity(
                onAboutButtonClick = {
                    navController.navigate(Screen.ABOUT_DEVICE.root)
                },
            )
        }


        composable(Screen.ABOUT_DEVICE.root) {
            AboutScreenActivity(
                onUpButtonClick =
                {
                    navController.popBackStack()
                }
            )
        }
    }


}
