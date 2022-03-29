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
    suspend fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>>

    suspend fun insert()

    class Base @Inject constructor(
        private val cacheDataSource: CacheDataSource,
        private val cloudDataSource: CloudDataSource,
    ) : MealRepository {
        override suspend fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>> {
            if (cacheDataSource.cacheIsEmpty()) {
                MealCategory.values().forEach {mealCategory->
                    cloudDataSource.downloadMeals(mealCategory).meals.forEach {
                        cacheDataSource.insertMeal(it.toCache(mealCategory))
                    }
                }
            }
            return Transformations.map(cacheDataSource.fetchMeals()) { list ->
                list.map {
                    it.toDomain()
                }
            }

        }

        override suspend fun insert() {
            cacheDataSource.insertMeal(MealCache("One","https://minecraft-statistic.net/img/screen/icon/146237.png",MealCategory.DESSERT))
        }

    }
}