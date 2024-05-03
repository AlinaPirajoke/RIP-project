package com.example.riptry2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.riptry2.screens.utils.DefaultField

@Composable
fun ModifyProductScreen(){
    var name by remember { mutableStateOf("") }
    var descr by remember { mutableStateOf("") }
    var left by remember { mutableStateOf(0) }

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        DefaultField(title = "Название", value = name, onChange = {name = it})
        DefaultField(title = "Описание", value = descr, onChange = {descr = it})
        DefaultField(title = "Количество на складе", value = left, onChange = {left = it})
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Создать", style = MaterialTheme.typography.bodyMedium)
        }
    }
}