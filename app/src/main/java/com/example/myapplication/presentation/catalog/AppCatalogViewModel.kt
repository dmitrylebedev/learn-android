package com.example.myapplication.presentation.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.AppCatalogRepositoryImpl
import com.example.myapplication.domain.repository.AppCatalogRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppCatalogViewModel : ViewModel() {

    private val repository: AppCatalogRepository = AppCatalogRepositoryImpl()

    private val _state = MutableStateFlow(AppCatalogState())
    val state: StateFlow<AppCatalogState> = _state.asStateFlow()

    private val _event = MutableSharedFlow<AppCatalogEvent>(extraBufferCapacity = 1)
    val event: SharedFlow<AppCatalogEvent> = _event.asSharedFlow()

    init {
        viewModelScope.launch {
            val apps = repository.getApps()
            _state.update { it.copy(apps = apps) }
        }
    }

    fun onLogoClick() {
        _event.tryEmit(AppCatalogEvent.ShowSnack("Логотип нажат"))
    }
}
