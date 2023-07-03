package com.example.usupbekov_adilet_5_2hw.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.usupbekov_adilet_5_2hw.simpleModels.Love

@Database(entities = [LoveDao::class] , version = 1)

abstract class AppDatabase:RoomDatabase() {
    abstract fun loveDao() : LoveDao
}