package com.example.riptry2.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.riptry2.viewmodels.states.utils.ApplicationStatus

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


    @Insert(entity = AnnouncementEntity::class)
    fun insertAnnouncement(announcement: AnnouncementEntity)

    @Update(entity = AnnouncementEntity::class)
    fun updateAnnouncement(announcement: AnnouncementEntity)

    @Delete(entity = AnnouncementEntity::class)
    fun deleteAnnouncement(announcement: AnnouncementEntity)

    @Query("select * from announcement where status = :status")
    fun getAnnouncementsList(status: Int): List<AnnouncementEntity>

    @Query("select * from announcement where id = :id")
    fun getAnnouncement(id: Int): AnnouncementEntity

    @Insert(entity = AnnouncementProductEntity::class)
    fun insertRequired(announcement: AnnouncementProductEntity)

    @Query("select * from announcement_product where applicationId = :id")
    fun getRequired(id: Int): List<AnnouncementProductEntity>

}