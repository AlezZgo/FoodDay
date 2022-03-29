package com.example.funday.domain

import androidx.lifecycle.LiveData
import com.example.funday.data.MealRepository
import javax.inject.Inject

interface MealInteractor {

    suspend fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>>

    class Base@Inject constructor(private val repository: MealRepository) : MealInteractor {
        override suspend fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>> {
            return repository.fetchMeals(category)
        }
    }
}