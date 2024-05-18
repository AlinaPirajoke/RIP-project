package com.example.riptry2.viewmodels

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riptry2.model.RoomDbManager
import com.example.riptry2.navigation.Destination
import com.example.riptry2.viewmodels.states.ModifyProductState
import com.example.riptry2.viewmodels.states.mapToProductEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ModifyProductViewModel(
    val productId: Int?,
    val db: RoomDbManager,
    val onAction: (Destination) -> Unit,
) : ViewModel() {
    private val _state = MutableStateFlow(ModifyProductState())
    val state: StateFlow<ModifyProductState> = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            productId?.let {
                val product = db.getProductInfo(it)
                _state.update {
                    ModifyProductState(
                        name = product.title,
                        descr = product.description,
                        left = product.left.toString()
                    )
                }
            }
        }
    }

    fun updateName(new: String) {
        _state.update { state ->
            state.copy(name = new)
        }
    }

    fun updateDescr(new: String) {
        _state.update { state ->
            state.copy(descr = new)
        }
    }

    fun updateLeft(new: String) {
        if (new.isDigitsOnly()) {
            _state.update { state ->
                state.copy(left = new)
            }
        }
    }

    fun onConfirm() {
        viewModelScope.launch(Dispatchers.IO) {
            if (productId == null) {
                db.insertProduct(state.value.mapToProductEntity())
                onAction(Destination.ProductList)
            } else {
                db.updateProduct(state.value.mapToProductEntity(productId))
                onAction(Destination.ProductInfo(productId))
            }

        }
    }
}