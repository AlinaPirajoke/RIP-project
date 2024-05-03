package com.example.riptry2.viewmodels

import com.example.riptry2.model.RoomDbManager
import com.example.riptry2.navigation.Destination
import com.example.riptry2.viewmodels.states.ApplicationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ApplicationViewModel(
    applicationId: Int,
    private val db: RoomDbManager,
    val onNavigate: (Destination) -> Unit,
) {
    private val _state = MutableStateFlow(db.getApplicationInfo(applicationId))
    val state: StateFlow<ApplicationState> = _state.asStateFlow()
}