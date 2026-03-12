package com.example.myapplication.data

import com.example.myapplication.model.AppCategory
import com.example.myapplication.model.AppDetailsEntry
import com.example.myapplication.model.AppListEntry

object DemoAppsRepository {
    val appList: List<AppListEntry> = listOf(
        AppListEntry(
            id = "1",
            title = "СберБанк Онлайн",
            subtitle = "Платежи, переводы и кешбэк",
            category = AppCategory.FINANCE,
            iconUrl = "https://free-png.ru/wp-content/uploads/2020/09/icon_sber-01-370x370.png",
        ),
        AppListEntry(
            id = "2",
            title = "Яндекс Браузер",
            subtitle = "Быстрый и безопасный браузер",
            category = AppCategory.UTILITIES,
            iconUrl = "https://cdn.ruwiki.ru/commonswiki/files/thumb/8/84/Yandex.Browser_icon.svg/800px-Yandex.Browser_icon.svg.png",
        ),
        AppListEntry(
            id = "3",
            title = "Почта Mail",
            subtitle = "Почта для всех ваших ящиков",
            category = AppCategory.UTILITIES,
            iconUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKgMBfD1oNsXwA3qfM1poC8ET5S292Jks7mg&s",
        ),
        AppListEntry(
            id = "4",
            title = "Яндекс Навигатор",
            subtitle = "Маршруты, пробки и заправки",
            category = AppCategory.TRANSPORT,
            iconUrl = "https://download.logo.wine/logo/Yandex.Navigator/Yandex.Navigator-Logo.wine.png",
        ),
        AppListEntry(
            id = "5",
            title = "VK Музыка",
            subtitle = "Музыка и рекомендации",
            category = AppCategory.MUSIC,
            iconUrl = "https://sun9-4.userapi.com/impg/1x6VbJjR6f5T0OwYf_JA7m0guQaxQf5MJmyj3A/lQ0lU2h7hzU.jpg?size=512x512&quality=95&sign=e5f0f4fe2fc91886f347f4a3f7481424&type=album",
        ),
        AppListEntry(
            id = "6",
            title = "VK Play",
            subtitle = "Игры и игровые сообщества",
            category = AppCategory.GAMES,
            iconUrl = "https://vkplay.ru/hotbox/content_files/news/2023/08/30/0f47a1a4f0de4f23b06f427cf4f3f8e2.jpg",
        ),
    )

    private val appDetailsById: Map<String, AppDetailsEntry> = mapOf(
        "1" to AppDetailsEntry(
            appId = "1",
            title = "Гильдия Героев: Экшен ММО РПГ",
            developerName = "VK Play",
            category = AppCategory.GAMES,
            ageLabel = "12+",
            sizeLabel = "223 MB",
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
            screenshotUrls = listOf(
                "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
                "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
                "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
            ),
            description = "Легендарная фэнтези RPG с PvE и PvP активностями. " +
                "Собирайте отряд, прокачивайте персонажей и проходите подземелья вместе с друзьями.",
        ),
    )

    fun findDetails(appId: String): AppDetailsEntry {
        return appDetailsById[appId] ?: appDetailsById.getValue("1")
    }
}
