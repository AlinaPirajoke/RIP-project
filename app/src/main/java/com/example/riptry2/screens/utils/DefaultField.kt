package com.example.riptry2.screens.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultField(
    title: String,
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = title, modifier = Modifier.padding(start = 16.dp), style = MaterialTheme.typography.bodyMedium)
        OutlinedTextField(value = value, onValueChange = onChange)
    }
}

@Composable
fun DefaultField(
    title: String,
    value: Int,
    onChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val valueString = value.toString()
    DefaultField(
        title = title,
        value = if (valueString == "0") "" else valueString,
        onChange = { text -> onChange(text.takeWhile { it.isDigit() }.toInt())},
        modifier = modifier
    )
}