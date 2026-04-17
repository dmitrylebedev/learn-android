package com.example.myapplication.data.repository

import com.example.myapplication.data.mapper.AppDetailsMapper
import com.example.myapplication.data.mapper.AppListMapper
import com.example.myapplication.domain.model.AppDetailsEntry
import com.example.myapplication.data.source.DemoAppsDataSource
import com.example.myapplication.domain.model.AppListEntry
import com.example.myapplication.domain.repository.AppCatalogRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppCatalogRepositoryImpl @Inject constructor(
    private val dataSource: DemoAppsDataSource,
    private val mapper: AppListMapper,
    private val detailsMapper: AppDetailsMapper,
) : AppCatalogRepository {

    override suspend fun getApps(): List<AppListEntry> {
        val dtos = dataSource.loadAppList()
        return mapper.toDomainList(dtos)
    }

    override suspend fun getAppDetails(appId: String): AppDetailsEntry {
        val details = dataSource.loadAppDetails(appId)
        return detailsMapper.toDomain(details)
    }
}
