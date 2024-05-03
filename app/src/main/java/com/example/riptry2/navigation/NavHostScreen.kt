package com.example.riptry2.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.riptry2.model.RoomDbManager
import com.example.riptry2.screens.ApplicationScreen
import com.example.riptry2.screens.AuthScreen
import com.example.riptry2.screens.DefaultListScreen
import com.example.riptry2.screens.ModifyProductScreen
import com.example.riptry2.viewmodels.ActiveListViewModel
import com.example.riptry2.viewmodels.ApplicationViewModel
import com.example.riptry2.viewmodels.HistoryListViewModel
import com.example.riptry2.viewmodels.IncomeListViewModel
import com.example.riptry2.viewmodels.ProductListViewModel
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavHost
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavHostScreen() {

    val navController = rememberNavController<Destination>(
        startDestination = Destination.Auth
    )
    var isAdmin by remember { mutableStateOf(false) }
    val db by remember { mutableStateOf(RoomDbManager()) }

    NavBackHandler(navController)
    NavHost(navController) { destination ->
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    title = {
                        Text(
                            text = getTitleString(destination),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar(actions = {})
            }

        ) { padding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                color = MaterialTheme.colorScheme.background,
            ) {
                when (destination) {

                    // Авторизация
                    is Destination.Auth ->
                        AuthScreen(onRolePick = {
                            isAdmin = it
                            navController.navigate(if (isAdmin) Destination.IncomeApplicationList else Destination.ActiveApplicationList)
                        })

                    // Блок заявок
                    is Destination.IncomeApplicationList -> DefaultListScreen(
                        IncomeListViewModel(
                            db = db,
                            onPickOption = { navController.navigate(Destination.ApplicationInfo(it)) }
                        )
                    )

                    is Destination.ActiveApplicationList -> DefaultListScreen(
                        ActiveListViewModel(
                            db = db,
                            onPickOption = { navController.navigate(Destination.ApplicationInfo(it)) }
                        )
                    )

                    is Destination.HistoryApplicationList -> DefaultListScreen(
                        HistoryListViewModel(
                            db = db,
                            onPickOption = { navController.navigate(Destination.ApplicationInfo(it)) }
                        )
                    )

                    is Destination.ApplicationInfo -> ApplicationScreen(
                        vm = ApplicationViewModel(
                            applicationId = destination.applicationId,
                            db = db,
                            onNavigate = navController::navigate
                        )
                    )

                    // Блок товаров
                    is Destination.ProductList -> DefaultListScreen(
                        ProductListViewModel(
                            db = db,
                            onPickOption = { navController.navigate(Destination.ProductInfo(it)) }
                        )
                    )

                    is Destination.ProductInfo -> {}

                    is Destination.ModifyProduct -> ModifyProductScreen()
                }
            }
        }
    }
}

fun getTitleString(destination: Destination): String =
    when (destination) {
        is Destination.Auth -> "Выбор пользователя"

        is Destination.IncomeApplicationList -> "Входящие заявки"
        is Destination.ActiveApplicationList -> "Активные заявки"
        is Destination.HistoryApplicationList -> "Законченные заявки"
        is Destination.ApplicationInfo -> "Заявка №${destination.applicationId}"

        is Destination.ProductInfo -> "Информация о продукте"
        is Destination.ProductList -> "База продуктов"
        is Destination.ModifyProduct -> if (destination.productId == null) "Создание товара" else "Изменение товара"
    }
