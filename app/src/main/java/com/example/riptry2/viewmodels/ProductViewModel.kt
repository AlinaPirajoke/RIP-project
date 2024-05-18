package com.example.riptry2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riptry2.model.RoomDbManager
import com.example.riptry2.navigation.Destination
import com.example.riptry2.viewmodels.states.ProductState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel(
    val productId: Int,
    db: RoomDbManager,
    val onAction: (Destination) -> Unit,
) : ViewModel() {
    private val _state = MutableStateFlow(ProductState())
    val state: StateFlow<ProductState> = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                db.getProductInfo(productId)
            }
        }
    }

    fun onEdit() {
        onAction(Destination.ModifyProduct(productId))
    }
}