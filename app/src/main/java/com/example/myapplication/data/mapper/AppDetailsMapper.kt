package com.example.myapplication.data.mapper

import com.example.myapplication.data.dto.AppDetailsDto
import com.example.myapplication.domain.model.AppCategory
import com.example.myapplication.domain.model.AppDetailsEntry
import javax.inject.Inject

class AppDetailsMapper @Inject constructor() {
    fun toDomain(dto: AppDetailsDto): AppDetailsEntry = AppDetailsEntry(
        appId = dto.id,
        title = dto.name,
        developerName = dto.developer,
        category = mapCategory(dto.category),
        ageLabel = "${dto.ageRating}+",
        sizeLabel = formatSize(dto.size),
        iconUrl = dto.iconUrl,
        screenshotUrls = dto.screenshotUrlList,
        description = dto.description,
    )

    private fun formatSize(sizeMb: Double): String {
        val rounded = ((sizeMb * 10).toInt()) / 10.0
        return if (rounded % 1.0 == 0.0) {
            "${rounded.toInt()} MB"
        } else {
            "$rounded MB"
        }
    }

    private fun mapCategory(category: String): AppCategory = when (category) {
        "Финансы" -> AppCategory.FINANCE
        "Навигация" -> AppCategory.TRANSPORT
        "Музыка" -> AppCategory.MUSIC
        "Игры" -> AppCategory.GAMES
        else -> AppCategory.UTILITIES
    }
}
