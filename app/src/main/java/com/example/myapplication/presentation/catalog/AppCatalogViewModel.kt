package com.example.myapplication.presentation.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.domain.repository.AppCatalogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class AppCatalogViewModel @Inject constructor(
    private val repository: AppCatalogRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(AppCatalogState())
    val state: StateFlow<AppCatalogState> = _state.asStateFlow()

    private val _event = MutableSharedFlow<AppCatalogEvent>(extraBufferCapacity = 1)
    val event: SharedFlow<AppCatalogEvent> = _event.asSharedFlow()

    init {
        loadApps()
    }

    fun retry() {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = null) }
            runCatching { repository.getApps() }
                .onSuccess { apps ->
                    _state.update {
                        it.copy(
                            apps = apps,
                            isLoading = false,
                            errorMessage = null,
                        )
                    }
                }
                .onFailure {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = "Не удалось загрузить каталог",
                            apps = emptyList(),
                        )
                    }
                }
        }
    }

    fun onLogoClick() {
        _event.tryEmit(AppCatalogEvent.ShowSnack(R.string.catalog_logo_clicked))
    }
}
