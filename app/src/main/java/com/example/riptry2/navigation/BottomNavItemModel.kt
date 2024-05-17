package com.example.riptry2.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.riptry2.R

data class BottomNavItemModel(
    val title: String,
    val icon: ImageVector,
    val destination: Destination
)

@Composable
fun getBottomNavItemModels(isAdmin: Boolean): List<BottomNavItemModel> {
    val list = arrayListOf(
        BottomNavItemModel(
            title = "Активные",
            icon = ImageVector.vectorResource(R.drawable.active),
            destination = Destination.ActiveApplicationList
        ),
        BottomNavItemModel(
            title = "История",
            icon = ImageVector.vectorResource(R.drawable.history),
            destination = Destination.HistoryApplicationList
        ),
        BottomNavItemModel(
            title = "Товары",
            icon = ImageVector.vectorResource(R.drawable.product),
            destination = Destination.ProductList
        )
    )
    if (isAdmin)
        list.add(
            BottomNavItemModel(
                title = "Входящие",
                icon = ImageVector.vectorResource(R.drawable.income),
                destination = Destination.IncomeApplicationList
            )
        )
    return list
}

@Composable
fun NavIcon(model: BottomNavItemModel, onClick: () -> Unit, isPicked: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(bottom = 8.dp)
            .size(75.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick() }) {
        Icon(
            imageVector = model.icon,
            contentDescription = model.title,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = model.title,
            style = if (isPicked) MaterialTheme.typography.labelMedium else MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Clip
        )
    }
}

@Composable
fun BottomBar(onPick: (Destination) -> Unit, destination: Destination, isAdmin: Boolean) {
    BottomAppBar {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            getBottomNavItemModels(isAdmin = isAdmin).forEach {
                NavIcon(
                    model = it,
                    onClick = { onPick(it.destination) },
                    isPicked = it.destination == destination
                )
            }
        }
    }
}