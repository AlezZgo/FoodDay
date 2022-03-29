package com.example.funday.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.funday.data.cache.CacheDataSource
import com.example.funday.data.cache.MealCache
import com.example.funday.data.cloud.CloudDataSource
import com.example.funday.domain.MealCategory
import com.example.funday.domain.MealDomain
import javax.inject.Inject

interface MealRepository {

    suspend fun download()

    fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>>

    class Base @Inject constructor(
        private val cacheDataSource: CacheDataSource,
        private val cloudDataSource: CloudDataSource,
    ) : MealRepository {
        override suspend fun download() {
            if (cacheDataSource.cacheIsEmpty()) {
                MealCategory.values().forEach {mealCategory->
                    cloudDataSource.downloadMeals(mealCategory).meals.forEach {
                        cacheDataSource.insertMeal(it.toCache(mealCategory))
                    }
                }
            }
        }

        override fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>> {
            return Transformations.map(cacheDataSource.fetchMeals()) { list ->
                list.map {
                    it.toDomain()
                }
            }

        }

    }
}