package com.example.riptry2.navigation

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class Destination : Parcelable {

    @Parcelize
    data object Auth : Destination()

    @Parcelize
    data object ProductList : Destination()

    @Parcelize
    data class ProductInfo(val productId: Int) : Destination()

    @Parcelize
    data object IncomeApplicationList : Destination()

    @Parcelize
    data object ActiveApplicationList : Destination()

    @Parcelize
    data object HistoryApplicationList : Destination()

    @Parcelize
    data class ApplicationInfo(val applicationId: Int) : Destination()

    @Parcelize
    data class ModifyProduct(val productId: Int?) : Destination()
}