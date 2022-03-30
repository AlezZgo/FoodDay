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

    class Test : CacheDataSource {
        val list = MutableLiveData<MutableList<MealCache>>()

        init {
            list.value?.add(MealCache("Burger","http://www.appletozucchini.com.au/wp-content/uploads/2016/08/mcdonalds-Cheeseburger.png",MealCategory.BREAKFAST))
        }

        override fun fetchMeals(category: MealCategory): LiveData<List<MealCache>> {
            return list as LiveData<List<MealCache>>
        }

        override suspend fun insertMeal(mealCache: MealCache) {
            list.value?.add(mealCache)
        }

        override suspend fun cacheIsEmpty(): Boolean {
            return list.value?.size!! <= 0
        }

    }
}