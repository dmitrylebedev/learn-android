package com.example.myapplication.data.source

import com.example.myapplication.data.dto.AppListItemDto

class DemoAppsDataSource {
    fun loadAppList(): List<AppListItemDto> = demoApps
}

private const val DEFAULT_ICON_URL =
    "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp"

private val demoApps: List<AppListItemDto> = listOf(
    AppListItemDto(
        id = "1",
        title = "СберБанк Онлайн",
        subtitle = "Платежи, переводы и кешбэк",
        categoryKey = "FINANCE",
        iconUrl = DEFAULT_ICON_URL,
    ),
    AppListItemDto(
        id = "2",
        title = "Яндекс Браузер",
        subtitle = "Быстрый и безопасный браузер",
        categoryKey = "UTILITIES",
        iconUrl = DEFAULT_ICON_URL,
    ),
    AppListItemDto(
        id = "3",
        title = "Почта Mail",
        subtitle = "Почта для всех ваших ящиков",
        categoryKey = "UTILITIES",
        iconUrl = DEFAULT_ICON_URL,
    ),
    AppListItemDto(
        id = "4",
        title = "Яндекс Навигатор",
        subtitle = "Маршруты, пробки и заправки",
        categoryKey = "TRANSPORT",
        iconUrl = DEFAULT_ICON_URL,
    ),
    AppListItemDto(
        id = "5",
        title = "Мой МТС",
        subtitle = "Центр экосистемы МТС",
        categoryKey = "UTILITIES",
        iconUrl = DEFAULT_ICON_URL,
    ),
    AppListItemDto(
        id = "6",
        title = "Яндекс — с Алисой",
        subtitle = "Поиск и сервисы под рукой",
        categoryKey = "UTILITIES",
        iconUrl = DEFAULT_ICON_URL,
    ),
)
