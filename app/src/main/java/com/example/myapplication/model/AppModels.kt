package com.example.myapplication.model

enum class AppCategory {
    FINANCE,
    UTILITIES,
    TRANSPORT,
    MUSIC,
    GAMES,
}

data class AppListEntry(
    val id: String,
    val title: String,
    val subtitle: String,
    val category: AppCategory,
    val iconUrl: String,
)
