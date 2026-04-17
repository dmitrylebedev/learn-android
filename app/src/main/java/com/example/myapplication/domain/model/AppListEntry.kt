package com.example.myapplication.domain.model

data class AppListEntry(
    val id: String,
    val title: String,
    val subtitle: String,
    val category: AppCategory,
    val iconUrl: String,
)

data class AppDetailsEntry(
    val appId: String,
    val title: String,
    val developerName: String,
    val category: AppCategory,
    val ageLabel: String,
    val sizeLabel: String,
    val iconUrl: String,
    val screenshotUrls: List<String>,
    val description: String,
)
