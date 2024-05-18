package com.example.riptry2.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.riptry2.viewmodels.states.ProductState
import com.example.riptry2.viewmodels.states.utils.ApplicationStatus
import com.example.riptry2.viewmodels.states.utils.ListOptionModel

@Entity(tableName = "announcement")
data class AnnouncementEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val status: Int = ApplicationStatus.INCOME.status
)

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val left: Int = 0
)

@Entity(
    tableName = "announcement_product", foreignKeys = [
        ForeignKey(
            entity = AnnouncementEntity::class,
            parentColumns = ["id"],
            childColumns = ["productId"]
        ),
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["id"],
            childColumns = ["applicationId"]
        )
    ]
)
data class AnnouncementProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val productId: Int = 0,
    val applicationId: Int = 0,
    val quantity: Int = 0
)

fun ProductEntity.mapToProductState(): ProductState =
    ProductState(
        id = this.id,
        title = this.title,
        description = this.description,
        left = this.left
    )

fun ProductEntity.mapToListModel(): ListOptionModel =
    ListOptionModel(id = this.id, text = this.title)

fun AnnouncementEntity.mapToListModel(): ListOptionModel =
    ListOptionModel(id = this.id, text = this.title)