package com.example.riptry2.viewmodels.states

import com.example.riptry2.model.ProductEntity

data class ModifyProductState(
    val name: String = "",
    val descr: String = "",
    val left: String = "",
)

fun ModifyProductState.mapToProductEntity(id: Int = 0): ProductEntity =
    ProductEntity(id = id, title = this.name, description = this.descr, left = this.left.toInt())
