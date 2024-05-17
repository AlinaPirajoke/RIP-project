package com.example.riptry2.model

import com.example.riptry2.viewmodels.states.ApplicationState
import com.example.riptry2.viewmodels.states.ProductState
import com.example.riptry2.viewmodels.states.utils.ListOptionModel
import com.example.riptry2.viewmodels.states.utils.RequiredProduct

class RoomDbManager() {

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

    fun getProductList(): ArrayList<ListOptionModel> {
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

    fun getProductInfo(productId: Int): ProductState =
        ProductState(
            id = productId,
            title = "Стальные балки",
            description = "Прочные конструкционные элементы, используемые в строительстве для поддержки настилов, полов и кровли. Они могут быть установлены как горизонтально, так и под углом и часто применяются при создании пролетов и строительстве мостов. Стальные балки бывают разных типов, включая прокатные и сварные, и могут быть изготовлены различными методами, такими как горячая прокатка или гнутье листовой стали.\u200B",
            left = 80
        )
}