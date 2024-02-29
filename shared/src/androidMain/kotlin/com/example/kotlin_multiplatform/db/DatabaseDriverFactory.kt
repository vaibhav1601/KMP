package com.example.kotlin_multiplatform.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = ArticleDB.Schema,
            context = context,
            name = "com.example.kotlin_multiplatform.db"

        )
}