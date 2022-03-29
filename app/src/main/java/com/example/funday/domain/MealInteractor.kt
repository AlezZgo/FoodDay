package com.example.funday.domain

import androidx.lifecycle.LiveData
import com.example.funday.data.MealRepository

interface MealInteractor {

    fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>>

    class Base(private val repository: MealRepository) : MealInteractor {
        override fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>> {
            return repository.fetchMeals(category)
        }
    }
}