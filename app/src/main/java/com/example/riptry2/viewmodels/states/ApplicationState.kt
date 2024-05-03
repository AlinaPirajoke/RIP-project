package com.example.riptry2.viewmodels.states

import com.example.riptry2.viewmodels.states.utils.RequiredProduct

data class ApplicationState(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val required: ArrayList<RequiredProduct> = arrayListOf()
)
