package com.example.riptry2.viewmodels.states.utils

import com.example.riptry2.model.AnnouncementProductEntity
import com.example.riptry2.model.ProductEntity

data class RequiredProduct(
    val id: Int,
    val name: String,
    val required: Int = 0,
    val left: Int = 0
)

fun joinToRequiredProduct(required: AnnouncementProductEntity, product: ProductEntity) =
    RequiredProduct(
        name = product.title,
        required = required.quantity,
        left = product.left,
        id = product.id
    )
