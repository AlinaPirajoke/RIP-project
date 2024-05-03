package com.example.riptry2.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.riptry2.screens.utils.DefaultButton

@Composable
fun AuthScreen(onRolePick: (Boolean) -> Unit){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            DefaultButton(text = "Войти как Администратор") {
                onRolePick(true)
            }
            Spacer(modifier = Modifier.size(16.dp))
            DefaultButton(text = "Войти как Грузчик") {
                onRolePick(false)
            }
        }
    }
}