package com.example.kotlin_multiplatform.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kotlin_multiplatform.db.ArticleDB
import com.example.kotlin_multiplatform.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DatabaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory(androidContext()).createDriver()
    }

    single<ArticleDB> {
        ArticleDB(get())
    }
}
