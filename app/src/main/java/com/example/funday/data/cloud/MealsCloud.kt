package com.example.funday.data.cloud

import com.google.gson.annotations.SerializedName

data class MealsCloud(
    @SerializedName("meals") val meals: List<MealCloud>,
)