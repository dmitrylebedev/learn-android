package com.example.myapplication.data.mapper

import com.example.myapplication.data.dto.AppListItemDto
import com.example.myapplication.domain.model.AppCategory
import com.example.myapplication.domain.model.AppListEntry
import javax.inject.Inject

class AppListMapper @Inject constructor() {
    fun toDomain(dto: AppListItemDto): AppListEntry = AppListEntry(
        id = dto.id,
        title = dto.name,
        subtitle = dto.description,
        category = mapCategory(dto.category),
        iconUrl = dto.iconUrl,
    )

    fun toDomainList(dtos: List<AppListItemDto>): List<AppListEntry> =
        dtos.map(::toDomain)

    private fun mapCategory(category: String): AppCategory = when (category) {
        "Финансы" -> AppCategory.FINANCE
        "Навигация" -> AppCategory.TRANSPORT
        "Музыка" -> AppCategory.MUSIC
        "Игры" -> AppCategory.GAMES
        else -> AppCategory.UTILITIES
    }
}
