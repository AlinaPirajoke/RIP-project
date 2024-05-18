package com.example.riptry2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riptry2.model.RoomDbManager
import com.example.riptry2.navigation.Destination
import com.example.riptry2.viewmodels.states.ListState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class DefaultListViewModel(private val onAction: (Destination) -> Unit): ViewModel()  {

    protected val _state = MutableStateFlow(ListState())
    val state: StateFlow<ListState> = _state.asStateFlow()

    abstract fun getList()

    open fun onPickOption(id: Int) = onAction(Destination.ApplicationInfo(id))
}

class IncomeListViewModel(val db: RoomDbManager, onAction: (Destination) -> Unit) : DefaultListViewModel(onAction) {
    init { getList() }
    override fun getList() {
        _state.update { state ->
            state.copy(list = db.getIncomeList())
        }
    }
}

class ActiveListViewModel(val db: RoomDbManager, onAction: (Destination) -> Unit) : DefaultListViewModel(onAction) {
    init { getList() }
    override fun getList() {
        _state.update { state ->
            state.copy(list = db.getActiveList())
        }
    }
}

class HistoryListViewModel(val db: RoomDbManager, onAction: (Destination) -> Unit) : DefaultListViewModel(onAction) {
    init { getList() }
    override fun getList() {
        _state.update { state ->
            state.copy(list = db.getHistoryList())
        }
    }
}

class ProductListViewModel(val db: RoomDbManager, val onAction: (Destination) -> Unit) : DefaultListViewModel(onAction) {
    init { getList() }
    override fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { state ->
                state.copy(list = db.getProductList())
            }
        }
    }

    override fun onPickOption(id: Int) = onAction(Destination.ProductInfo(id))

    fun toCreateNew() = onAction(Destination.ModifyProduct(null))
}