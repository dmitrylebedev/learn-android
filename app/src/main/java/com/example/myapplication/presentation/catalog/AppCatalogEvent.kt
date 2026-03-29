package com.example.myapplication.presentation.catalog

sealed interface AppCatalogEvent {
    data class ShowSnack(val message: String) : AppCatalogEvent
}
