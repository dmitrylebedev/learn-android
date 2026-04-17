package com.example.myapplication.presentation.catalog

import com.example.myapplication.domain.model.AppListEntry

data class AppCatalogState(
    val apps: List<AppListEntry> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
