package com.example.funday.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.funday.data.cache.CacheDataSource
import com.example.funday.data.cloud.CloudDataSource
import com.example.funday.domain.MealCategory
import com.example.funday.domain.MealDomain
import javax.inject.Inject

interface MealRepository {
    suspend fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>>

    class Base @Inject constructor(
        private val cacheDataSource: CacheDataSource,
        private val cloudDataSource: CloudDataSource,
    ) : MealRepository {
        override suspend fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>> {
            if (cacheDataSource.cacheIsEmpty()) {
                cloudDataSource.downloadMeals(category).meals.forEach {
                    cacheDataSource.insertMeal(it.toCache(category))
                }
            }
            return Transformations.map(cacheDataSource.fetchMeals()) { list ->
                list.map {
                    it.toDomain()
                }
            }

        }

    }
}