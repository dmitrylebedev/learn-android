package com.example.myapplication.presentation.catalog

sealed interface AppCatalogEvent {
    data class ShowSnack(val messageResId: Int) : AppCatalogEvent
}
