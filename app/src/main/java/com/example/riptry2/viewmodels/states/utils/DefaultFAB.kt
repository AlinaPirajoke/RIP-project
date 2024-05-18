package com.example.riptry2.viewmodels.states.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun DefaultFAB(text: String, onClick: () -> Unit) {
    FloatingActionButton(
        modifier = Modifier.offset(x = -6.dp).shadow(
            elevation = 4.dp,
            shape = MaterialTheme.shapes.medium,
            spotColor = MaterialTheme.colorScheme.background
        ).border(width = 4.dp, color = MaterialTheme.colorScheme.background, shape = MaterialTheme.shapes.medium),
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}