package com.example.funday.data.cache

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.funday.data.cloud.MealCloud
import com.example.funday.domain.MealCategory
import javax.inject.Inject

interface CacheDataSource {
    fun fetchMeals(category: MealCategory): LiveData<List<MealCache>>

    suspend fun insertMeal(mealCache: MealCache)

    suspend fun cacheIsEmpty(): Boolean

    class Base @Inject constructor(private val mealDao: MealDao) : CacheDataSource {
        override fun fetchMeals(category: MealCategory): LiveData<List<MealCache>> {
            return mealDao.list(category)
        }

        override suspend fun insertMeal(meal: MealCache) {
            mealDao.insert(meal)
        }

        override suspend fun cacheIsEmpty(): Boolean {
            return mealDao.count() <= 0
        }
    }


}