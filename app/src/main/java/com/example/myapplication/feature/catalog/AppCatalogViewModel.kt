package com.example.myapplication.feature.catalog

import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import com.example.myapplication.data.DemoAppsRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class AppCatalogViewModel : ViewModel() {
    private val _state = MutableStateFlow(
        AppCatalogState(
            apps = DemoAppsRepository.appList,
        )
    )
    val state: StateFlow<AppCatalogState> = _state.asStateFlow()

    private val _event = MutableSharedFlow<AppCatalogEvent>(extraBufferCapacity = 1)
    val event: SharedFlow<AppCatalogEvent> = _event.asSharedFlow()

    fun onLogoClick() {
        _event.tryEmit(AppCatalogEvent.ShowSnack(R.string.catalog_logo_clicked))
    }
}
