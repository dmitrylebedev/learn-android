package com.example.myapplication.feature.catalog

sealed interface AppCatalogEvent {
    data class ShowSnack(val message: String) : AppCatalogEvent
}
