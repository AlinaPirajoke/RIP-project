package com.example.riptry2.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.riptry2.screens.utils.ListOption
import com.example.riptry2.viewmodels.DefaultListViewModel
import com.example.riptry2.viewmodels.ProductListViewModel
import com.example.riptry2.viewmodels.states.utils.DefaultFAB

@Composable
fun DefaultListScreen(vm: DefaultListViewModel) {
    val state by vm.state.collectAsState()

    Scaffold(
        floatingActionButton = {
            if(vm is ProductListViewModel){
                DefaultFAB(text = "Добавить", onClick = vm::toCreateNew)
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 20.dp)
        ) {
            items(state.list) { item ->
                ListOption(model = item) {
                    vm.onPickOption(item.id)
                }
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }
}