package com.example.riptry2.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import com.example.riptry2.model.RoomDbManager
import com.example.riptry2.screens.ApplicationScreen
import com.example.riptry2.screens.AuthScreen
import com.example.riptry2.screens.DefaultListScreen
import com.example.riptry2.screens.ModifyProductScreen
import com.example.riptry2.screens.ProductScreen
import com.example.riptry2.viewmodels.ActiveListViewModel
import com.example.riptry2.viewmodels.ApplicationViewModel
import com.example.riptry2.viewmodels.HistoryListViewModel
import com.example.riptry2.viewmodels.IncomeListViewModel
import com.example.riptry2.viewmodels.ModifyProductViewModel
import com.example.riptry2.viewmodels.ProductListViewModel
import com.example.riptry2.viewmodels.ProductViewModel
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
    val context = LocalContext.current
    var isAdmin by remember { mutableStateOf(false) }
    var isLogged by remember { mutableStateOf(false) }
    val db by remember { mutableStateOf(RoomDbManager(context)) }

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
                if (isLogged)
                    BottomBar(
                        onPick = navController::navigate,
                        destination = destination,
                        isAdmin = isAdmin
                    )
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
                    is Destination.Auth -> {
                        isLogged = false
                        AuthScreen(onRolePick = {
                            isAdmin = it
                            isLogged = true
                            navController.navigate(if (isAdmin) Destination.IncomeApplicationList else Destination.ActiveApplicationList)
                        })
                    }

                    // Блок заявок
                    is Destination.IncomeApplicationList -> DefaultListScreen(
                        IncomeListViewModel(
                            db = db,
                            onAction = navController::navigate
                        )
                    )

                    is Destination.ActiveApplicationList -> DefaultListScreen(
                        ActiveListViewModel(
                            db = db,
                            onAction = navController::navigate
                        )
                    )

                    is Destination.HistoryApplicationList -> DefaultListScreen(
                        HistoryListViewModel(
                            db = db,
                            onAction = navController::navigate
                        )
                    )

                    is Destination.ApplicationInfo -> ApplicationScreen(
                        vm = ApplicationViewModel(
                            applicationId = destination.applicationId,
                            db = db,
                            onAction = navController::navigate
                        )
                    )

                    // Блок товаров
                    is Destination.ProductList -> DefaultListScreen(
                        ProductListViewModel(
                            db = db,
                            onAction = navController::navigate
                        )
                    )

                    is Destination.ProductInfo -> {
                        ProductScreen(
                            vm = ProductViewModel(
                                productId = destination.productId,
                                db = db,
                                onAction = navController::navigate
                            )
                        )
                    }

                    is Destination.ModifyProduct -> ModifyProductScreen(
                        vm = ModifyProductViewModel(
                            productId = destination.productId,
                            db = db,
                            onAction = navController::navigate
                        )
                    )
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
