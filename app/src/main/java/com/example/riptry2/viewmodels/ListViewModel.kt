package com.example.riptry2.viewmodels

import androidx.lifecycle.ViewModel
import com.example.riptry2.model.RoomDbManager
import com.example.riptry2.viewmodels.states.ListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class DefaultListViewModel(val onPickOption: (Int) -> Unit): ViewModel()  {

    protected val _state = MutableStateFlow(ListState())
    val state: StateFlow<ListState> = _state.asStateFlow()

    abstract fun getList()
}

class IncomeListViewModel(val db: RoomDbManager, onPickOption: (Int) -> Unit) : DefaultListViewModel(onPickOption) {
    init { getList() }
    override fun getList() {
        _state.update { state ->
            state.copy(list = db.getIncomeList())
        }
    }
}

class ActiveListViewModel(val db: RoomDbManager, onPickOption: (Int) -> Unit) : DefaultListViewModel(onPickOption) {
    init { getList() }
    override fun getList() {
        _state.update { state ->
            state.copy(list = db.getActiveList())
        }
    }
}

class HistoryListViewModel(val db: RoomDbManager, onPickOption: (Int) -> Unit) : DefaultListViewModel(onPickOption) {
    init { getList() }
    override fun getList() {
        _state.update { state ->
            state.copy(list = db.getHistoryList())
        }
    }
}

class ProductListViewModel(val db: RoomDbManager, onPickOption: (Int) -> Unit) : DefaultListViewModel(onPickOption) {
    init { getList() }
    override fun getList() {
        _state.update { state ->
            state.copy(list = db.getProductList())
        }
    }
}