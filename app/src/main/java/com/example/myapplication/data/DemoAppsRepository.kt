package com.example.myapplication.data

import com.example.myapplication.model.AppCategory
import com.example.myapplication.model.AppListEntry

object DemoAppsRepository {
    private const val DEFAULT_ICON_URL = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp"

    val appList: List<AppListEntry> = listOf(
        AppListEntry(
            id = "1",
            title = "СберБанк Онлайн",
            subtitle = "Платежи, переводы и кешбэк",
            category = AppCategory.FINANCE,
            iconUrl = DEFAULT_ICON_URL,
        ),
        AppListEntry(
            id = "2",
            title = "Яндекс Браузер",
            subtitle = "Быстрый и безопасный браузер",
            category = AppCategory.UTILITIES,
            iconUrl = DEFAULT_ICON_URL,
        ),
        AppListEntry(
            id = "3",
            title = "Почта Mail",
            subtitle = "Почта для всех ваших ящиков",
            category = AppCategory.UTILITIES,
            iconUrl = DEFAULT_ICON_URL,
        ),
        AppListEntry(
            id = "4",
            title = "Яндекс Навигатор",
            subtitle = "Маршруты, пробки и заправки",
            category = AppCategory.TRANSPORT,
            iconUrl = DEFAULT_ICON_URL,
        ),
        AppListEntry(
            id = "5",
            title = "Мой МТС",
            subtitle = "Центр экосистемы МТС",
            category = AppCategory.UTILITIES,
            iconUrl = DEFAULT_ICON_URL,
        ),
        AppListEntry(
            id = "6",
            title = "Яндекс — с Алисой",
            subtitle = "Поиск и сервисы под рукой",
            category = AppCategory.UTILITIES,
            iconUrl = DEFAULT_ICON_URL,
        ),
    )
}
