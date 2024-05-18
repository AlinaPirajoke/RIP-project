package com.example.riptry2.model

import android.content.Context
import androidx.room.Room
import com.example.riptry2.viewmodels.states.ApplicationState
import com.example.riptry2.viewmodels.states.ProductState
import com.example.riptry2.viewmodels.states.utils.ListOptionModel
import com.example.riptry2.viewmodels.states.utils.RequiredProduct
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomDbManager(context: Context) {

    private val appDatabase: MainDatabase by lazy {
        Room.databaseBuilder(context, MainDatabase::class.java, "database")
            .build()
    }
    private val dao = appDatabase.getMainDao()

    init {
        /*GlobalScope.launch {
            dao.insertProduct(
                ProductEntity(
                    title = "Кофемашина Delonghi",
                    description = "Автоматическая кофемашина с возможностью приготовления эспрессо и капучино.",
                    left = 199
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Умные часы WatchIt",
                    description = "Водонепроницаемые умные часы с функцией мониторинга сердечного ритма.",
                    left = 150
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Беспроводные наушники SoundMax",
                    description = "Наушники с шумоподавлением и долгим временем автономной работы.",
                    left = 130
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Электросамокат Speedster",
                    description = "Складной электросамокат с максимальной скоростью до 25 км/ч.",
                    left = 180
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Робот-пылесос CleanBot",
                    description = "Автоматический робот-пылесос с функцией влажной уборки.",
                    left = 170
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Умная лампа Bright",
                    description = "LED-лампа с возможностью управления через смартфон.",
                    left = 50
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Электрогриль BBQPro",
                    description = "Стационарный электрогриль для приготовления шашлыков и стейков.",
                    left = 120
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Фитнес-браслет HealthTrack",
                    description = "Фитнес-браслет с функциями отслеживания активности и сна.",
                    left = 80
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Портативный проектор MiniCinema",
                    description = "Компактный проектор для домашнего кинотеатра с поддержкой Full HD.",
                    left = 200
                )
            )

            dao.insertProduct(
                ProductEntity(
                    title = "Виртуальные очки VRDream",
                    description = "Очки виртуальной реальности для погружения в мир игр и развлечений.",
                    left = 90
                )
            )
        }*/
    }

    suspend fun insertProduct(product: ProductEntity) =
        dao.insertProduct(product)

    suspend fun updateProduct(product: ProductEntity) =
        dao.updateProduct(product)

    suspend fun getProductInfo(productId: Int): ProductState =
        dao.getProduct(productId).mapToProductState()

    suspend fun getProductList(): ArrayList<ListOptionModel> {
        val models = arrayListOf<ListOptionModel>()

        dao.getProductsList().forEach { models.add(it.mapToListModel()) }
        return models
    }

    fun getIncomeList(): ArrayList<ListOptionModel> {
        return arrayListOf(
            ListOptionModel(1, "ei"),
            ListOptionModel(2, "ha"),
            ListOptionModel(3, "hihihi")
        )
    }

    fun getActiveList(): ArrayList<ListOptionModel> {
        return arrayListOf(
            ListOptionModel(1, "ei"),
            ListOptionModel(2, "ha"),
            ListOptionModel(3, "hihihi")
        )
    }

    fun getHistoryList(): ArrayList<ListOptionModel> {
        return arrayListOf(
            ListOptionModel(1, "ei"),
            ListOptionModel(2, "ha"),
            ListOptionModel(3, "hihihi")
        )
    }

    fun getApplicationInfo(appId: Int): ApplicationState =
        ApplicationState(
            id = appId,
            title = "ООО Электросталь 3",
            description = "Нужно отправить ласточку на Электросталь 3 до 23:59",
            required = arrayListOf(RequiredProduct("Носочки бежевые \"Talil\"", 40, 403))
        )

}