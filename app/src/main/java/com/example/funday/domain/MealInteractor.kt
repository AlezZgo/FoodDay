package com.example.funday.domain

import androidx.lifecycle.LiveData
import com.example.funday.data.MealRepository
import javax.inject.Inject

interface MealInteractor {

    fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>>

    suspend fun download()

    class Base @Inject constructor(private val repository: MealRepository) : MealInteractor {
        override fun fetchMeals(category: MealCategory): LiveData<List<MealDomain>> {
            return repository.fetchMeals(category)
        }

        override suspend fun download() {
            repository.download()
        }

    }
}