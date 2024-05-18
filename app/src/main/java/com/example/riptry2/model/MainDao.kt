package com.example.riptry2.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MainDao {

    @Insert(entity = ProductEntity::class)
    fun insertProduct(product: ProductEntity)

    @Update(entity = ProductEntity::class)
    fun updateProduct(product: ProductEntity)

    @Query("select * from product")
    fun getProductsList(): List<ProductEntity>

    @Query("select * from product where id = :id")
    fun getProduct(id: Int): ProductEntity
}