package com.example.riptry2.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.riptry2.viewmodels.ApplicationViewModel
import com.example.riptry2.viewmodels.states.utils.ApplicationStatus
import com.example.riptry2.viewmodels.states.utils.RequiredProduct

@Composable
fun ApplicationScreen(vm: ApplicationViewModel) {
    val state by vm.state.collectAsState()
    val buttonText = when (state.status) {
        ApplicationStatus.ACTIVE -> "Завершить"
        ApplicationStatus.DONE -> "Восстановить"
        ApplicationStatus.INCOME -> "Принять"
    }

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
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(MaterialTheme.shapes.small)
                    .clickable {
                    vm.pickRequire(item.id)
                }
            ) {
                Text(text = " - ", style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = buildRequiredString(item),
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (item.left < item.required) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onBackground,

                    )
            }
        }

        Box(
            Modifier
                .weight(1f)
                .padding(bottom = 32.dp, top = 32.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(onClick = vm::updateStatus, shape = MaterialTheme.shapes.medium) {
                    Text(
                        text = buttonText,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
                if (state.status == ApplicationStatus.INCOME) {
                    Spacer(modifier = Modifier.size((32.dp)))
                    Button(onClick = vm::deleteAnnouncement, shape = MaterialTheme.shapes.medium) {
                        Text(
                            text = "Отклонить",
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                }
            }
        }
    }
}

fun buildRequiredString(model: RequiredProduct) =
    "${model.name} - ${model.required}шт. из ${model.left}шт. (на складе)"