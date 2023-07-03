package com.example.usupbekov_adilet_5_2hw.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.usupbekov_adilet_5_2hw.simpleModels.Love

@Dao

interface LoveDao {
    @Insert
    fun insert(love: Love)

    @Query("SELECT * FROM Love ORDER BY id DESC")
    fun getAll(): List<Love>

    @Query("SELECT * FROM Love ORDER BY firstName ")
    fun getFirstName(): List<Love>

}