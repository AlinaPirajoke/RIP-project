package com.example.riptry2.screens.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.riptry2.viewmodels.states.utils.ListOptionModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOption(
    modifier: Modifier = Modifier,
    model: ListOptionModel,
    onClickAction: () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth().height(80.dp).padding(horizontal = 16.dp),
        onClick = onClickAction,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = model.id.toString() + ":",
                style = MaterialTheme.typography.titleLarge,
            )

            Spacer(Modifier.size(16.dp))

            Text(
                text = model.text,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}