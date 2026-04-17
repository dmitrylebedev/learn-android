package com.example.myapplication.data.network

import com.example.myapplication.data.dto.AppDetailsDto
import com.example.myapplication.data.dto.AppListItemDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CatalogApiService {
    @GET("catalog")
    suspend fun getCatalog(): List<AppListItemDto>

    @GET("catalog/{id}")
    suspend fun getAppDetails(
        @Path("id") id: String,
    ): AppDetailsDto
}
