package com.example.funday.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.funday.domain.MealCategory
import com.example.funday.domain.MealDomain

@Entity(tableName = "meals")
data class MealCache(
    @PrimaryKey
    val name: String,
    val url: String,
    val category: MealCategory,
) {
    fun toDomain() = MealDomain(name, url)
}


