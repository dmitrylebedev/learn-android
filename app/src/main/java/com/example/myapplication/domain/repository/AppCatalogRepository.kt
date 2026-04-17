package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.AppDetailsEntry
import com.example.myapplication.domain.model.AppListEntry

interface AppCatalogRepository {
    suspend fun getApps(): List<AppListEntry>
    suspend fun getAppDetails(appId: String): AppDetailsEntry
}
