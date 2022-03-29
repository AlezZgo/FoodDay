package com.example.funday.data.cache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.funday.domain.MealCategory

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(qrCode: MealCache)

    @Query("SELECT * FROM meals WHERE category LIKE :category ORDER BY name ASC")
    fun list(category: MealCategory): LiveData<List<MealCache>>

    @Query("SELECT COUNT(*) FROM meals ")
    suspend fun count(): Int

}