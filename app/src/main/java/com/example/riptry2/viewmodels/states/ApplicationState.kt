package com.example.riptry2.viewmodels.states

import com.example.riptry2.model.AnnouncementEntity
import com.example.riptry2.viewmodels.states.utils.ApplicationStatus
import com.example.riptry2.viewmodels.states.utils.RequiredProduct

data class ApplicationState(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val required: ArrayList<RequiredProduct> = arrayListOf(),
    val status: ApplicationStatus = ApplicationStatus.ACTIVE
)

fun ApplicationState.mapToAnnouncementEntity() =
    AnnouncementEntity(id = this.id, title = this.title, description = this.description, status = this.status.status)
