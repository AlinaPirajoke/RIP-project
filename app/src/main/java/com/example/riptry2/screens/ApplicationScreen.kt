package com.example.riptry2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.riptry2.viewmodels.ApplicationViewModel
import com.example.riptry2.viewmodels.states.utils.RequiredProduct

@Composable
fun ApplicationScreen(vm: ApplicationViewModel) {
    val state by vm.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 16.dp)
    ) {
        Text(text = state.title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = state.description, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Требуется:")

        state.required.forEach { item ->
            Row() {
                Text(text = " - ", style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = buildRequiredString(item),
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

fun buildRequiredString(model: RequiredProduct) =
    "${model.name} - ${model.required}шт. из ${model.left}шт. (на складе)"