package com.example.myapplication.data.source

import com.example.myapplication.data.dto.AppDetailsDto
import com.example.myapplication.data.dto.AppListItemDto
import com.example.myapplication.data.network.CatalogApiService
import javax.inject.Inject

class DemoAppsDataSource @Inject constructor(
    private val apiService: CatalogApiService,
) {
    suspend fun loadAppList(): List<AppListItemDto> = apiService.getCatalog()

    suspend fun loadAppDetails(appId: String): AppDetailsDto = apiService.getAppDetails(appId)
}
