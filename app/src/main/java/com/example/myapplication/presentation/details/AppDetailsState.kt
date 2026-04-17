package com.example.myapplication.presentation.details

import com.example.myapplication.domain.model.AppDetailsEntry

data class AppDetailsState(
    val details: AppDetailsEntry? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
