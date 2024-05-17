package com.example.riptry2.viewmodels

import com.example.riptry2.model.RoomDbManager
import com.example.riptry2.navigation.Destination
import com.example.riptry2.viewmodels.states.ApplicationState
import com.example.riptry2.viewmodels.states.ProductState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductViewModel (
        productId: Int,
        private val db: RoomDbManager,
        val onAction: (Destination) -> Unit,
    ) {
        private val _state = MutableStateFlow(db.getProductInfo(productId))
        val state: StateFlow<ProductState> = _state.asStateFlow()
}