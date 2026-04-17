package com.example.myapplication.feature.catalog

import com.example.myapplication.model.AppListEntry

data class AppCatalogState(
    val apps: List<AppListEntry> = emptyList(),
)
