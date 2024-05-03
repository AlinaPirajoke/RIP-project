package com.example.riptry2.model

import com.example.riptry2.viewmodels.states.ApplicationState
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
}