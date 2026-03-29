package com.example.myapplication.domain.model

data class AppListEntry(
    val id: String,
    val title: String,
    val subtitle: String,
    val category: AppCategory,
    val iconUrl: String,
)
