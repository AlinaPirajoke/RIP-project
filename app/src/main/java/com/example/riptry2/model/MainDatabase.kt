package com.example.riptry2.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        AnnouncementEntity::class,
        ProductEntity::class,
        AnnouncementProductEntity::class
    ]
)
abstract class MainDatabase : RoomDatabase() {
    abstract fun getMainDao(): MainDao

}