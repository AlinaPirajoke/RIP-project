package com.example.riptry2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.example.riptry2.R

data class BottomNavItemModelModel(
    val title: String,
    val icon: ImageVector,
    val destination: Destination
)

@Composable
fun getBottomNavItemModels(isAdmin: Boolean): List<BottomNavItemModelModel> {
    val list = arrayListOf(
        BottomNavItemModelModel(
            title = "Активные",
            icon = ImageVector.vectorResource(R.drawable.active),
            destination = Destination.ActiveApplicationList
        ),
        BottomNavItemModelModel(
            title = "История",
            icon = ImageVector.vectorResource(R.drawable.history),
            destination = Destination.HistoryApplicationList
        ),
        BottomNavItemModelModel(
            title = "Товары",
            icon = ImageVector.vectorResource(R.drawable.product),
            destination = Destination.ProductList
        )
    )
    if (isAdmin)
        list.add(
            BottomNavItemModelModel(
                title = "Входящие",
                icon = ImageVector.vectorResource(R.drawable.income),
                destination = Destination.IncomeApplicationList
            )
        )
    return list
}