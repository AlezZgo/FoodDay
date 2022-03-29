package com.example.funday.data.cloud

import com.example.funday.domain.MealCategory
import javax.inject.Inject

interface CloudDataSource {

    suspend fun downloadMeals(
        category: MealCategory,
    ): MealsCloud

    class Base @Inject constructor(private val service: MealsApiService) : CloudDataSource {
        override suspend fun downloadMeals(category: MealCategory): MealsCloud {

            return service.loadData(category.toString())
        }

    }

}