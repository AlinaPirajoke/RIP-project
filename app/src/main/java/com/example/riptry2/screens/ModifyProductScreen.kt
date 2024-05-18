package com.example.riptry2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.riptry2.screens.utils.DefaultField
import com.example.riptry2.ui.theme.shapes
import com.example.riptry2.viewmodels.ModifyProductViewModel

@Composable
fun ModifyProductScreen(vm: ModifyProductViewModel) {
    val state by vm.state.collectAsState()

    Column(
        Modifier.fillMaxSize().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DefaultField(title = "Название", value = state.name, onChange = vm::updateName)
        Spacer(Modifier.size(16.dp))
        DefaultField(title = "Описание", value = state.descr, onChange = vm::updateDescr)
        Spacer(Modifier.size(16.dp))
        DefaultField(title = "Количество на складе", value = state.left, onChange = vm::updateLeft)
        Spacer(Modifier.size(16.dp))
        Button(onClick = vm::onConfirm, shape = MaterialTheme.shapes.medium) {
            Text(
                text = "Создать",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}