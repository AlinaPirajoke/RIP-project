package com.example.riptry2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riptry2.model.RoomDbManager
import com.example.riptry2.navigation.Destination
import com.example.riptry2.viewmodels.states.ApplicationState
import com.example.riptry2.viewmodels.states.mapToAnnouncementEntity
import com.example.riptry2.viewmodels.states.utils.ApplicationStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ApplicationViewModel(
    applicationId: Int,
    private val db: RoomDbManager,
    val onAction: (Destination) -> Unit,
) : ViewModel() {
    private val _state = MutableStateFlow(ApplicationState())
    val state: StateFlow<ApplicationState> = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                db.getAnnouncementInfo(applicationId)
            }
        }
    }

    fun updateStatus(){
        viewModelScope.launch(Dispatchers.IO) {
            var announcement = state.value.mapToAnnouncementEntity()
            announcement = when (state.value.status) {
                ApplicationStatus.ACTIVE -> announcement.copy(status = ApplicationStatus.DONE.status)
                ApplicationStatus.DONE -> announcement.copy(status = ApplicationStatus.ACTIVE.status)
                ApplicationStatus.INCOME -> announcement.copy(status = ApplicationStatus.ACTIVE.status)
            }

            db.updateAnnouncement(announcement)

            when (state.value.status) {
                ApplicationStatus.ACTIVE -> onAction(Destination.HistoryApplicationList)
                ApplicationStatus.DONE -> onAction(Destination.ActiveApplicationList)
                ApplicationStatus.INCOME -> onAction(Destination.ActiveApplicationList)
            }
        }
    }

    fun deleteAnnouncement(){
        viewModelScope.launch(Dispatchers.IO) {
            db.deleteAnnouncement(state.value.mapToAnnouncementEntity())
            onAction(Destination.IncomeApplicationList)
        }
    }

    fun pickRequire(productId: Int){
        onAction(Destination.ProductInfo(productId))
    }
}