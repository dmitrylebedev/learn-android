package com.example.myapplication.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.repository.AppCatalogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val repository: AppCatalogRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(AppDetailsState())
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private var loadedAppId: String? = null

    fun load(appId: String) {
        if (loadedAppId == appId) return
        loadInternal(appId)
    }

    fun retry() {
        val appId = loadedAppId ?: return
        loadInternal(appId)
    }

    private fun loadInternal(appId: String) {
        loadedAppId = appId

        viewModelScope.launch {
            _state.update { it.copy(details = null, isLoading = true, errorMessage = null) }
            runCatching { repository.getAppDetails(appId) }
                .onSuccess { details ->
                    _state.update {
                        it.copy(
                            details = details,
                            isLoading = false,
                            errorMessage = null,
                        )
                    }
                }
                .onFailure {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = "Не удалось загрузить детали приложения",
                            details = null,
                        )
                    }
                }
        }
    }
}
