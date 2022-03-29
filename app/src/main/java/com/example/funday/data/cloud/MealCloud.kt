package com.example.funday.data.cloud

import com.example.funday.data.cache.MealCache
import com.example.funday.domain.MealCategory
import com.google.gson.annotations.SerializedName

data class MealCloud(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val url: String,
    @SerializedName("idMeal") val idMeal: Int,
) {
    fun toCache(category: MealCategory) = MealCache(name, url, category)
}
