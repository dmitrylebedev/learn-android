package com.example.myapplication.data.repository

import com.example.myapplication.data.mapper.AppListMapper
import com.example.myapplication.data.source.DemoAppsDataSource
import com.example.myapplication.domain.model.AppListEntry
import com.example.myapplication.domain.repository.AppCatalogRepository

class AppCatalogRepositoryImpl(
    private val dataSource: DemoAppsDataSource = DemoAppsDataSource(),
    private val mapper: AppListMapper = AppListMapper(),
) : AppCatalogRepository {

    override suspend fun getApps(): List<AppListEntry> {
        val dtos = dataSource.loadAppList()
        return mapper.toDomainList(dtos)
    }
}
