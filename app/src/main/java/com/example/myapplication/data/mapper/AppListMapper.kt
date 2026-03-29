package com.example.myapplication.data.mapper

import com.example.myapplication.data.dto.AppListItemDto
import com.example.myapplication.domain.model.AppCategory
import com.example.myapplication.domain.model.AppListEntry
import javax.inject.Inject

class AppListMapper @Inject constructor() {
    fun toDomain(dto: AppListItemDto): AppListEntry = AppListEntry(
        id = dto.id,
        title = dto.title,
        subtitle = dto.subtitle,
        category = mapCategory(dto.categoryKey),
        iconUrl = dto.iconUrl,
    )

    fun toDomainList(dtos: List<AppListItemDto>): List<AppListEntry> =
        dtos.map(::toDomain)

    private fun mapCategory(key: String): AppCategory = when (key) {
        "FINANCE" -> AppCategory.FINANCE
        "UTILITIES" -> AppCategory.UTILITIES
        "TRANSPORT" -> AppCategory.TRANSPORT
        "MUSIC" -> AppCategory.MUSIC
        "GAMES" -> AppCategory.GAMES
        else -> AppCategory.UTILITIES
    }
}
