package com.example.riptry2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.riptry2.navigation.Destination
import com.example.riptry2.viewmodels.ProductViewModel
import com.example.riptry2.viewmodels.states.utils.DefaultFAB

@Composable
fun ProductScreen(vm: ProductViewModel) {
    val state by vm.state.collectAsState()
    Scaffold(
        floatingActionButton = {
            DefaultFAB("Изменить") { vm.onAction(Destination.ModifyProduct(state.id)) }
        }
    ) {paddingValues ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 16.dp)
            .padding(paddingValues)
    ) {
        Text(text = state.title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "Осталось на складе: ${state.left} шт.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = state.description, style = MaterialTheme.typography.bodyMedium)
    }
    }
}