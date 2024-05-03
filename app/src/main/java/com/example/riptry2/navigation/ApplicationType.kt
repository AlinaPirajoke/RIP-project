package com.example.riptry2.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class ApplicationType : Parcelable {
    @Parcelize
    object Incoming : Parcelable

    @Parcelize
    object Active : Parcelable

    @Parcelize
    object History : Parcelable
}