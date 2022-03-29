package com.example.funday.presentation.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.funday.domain.MealCategory
import com.example.funday.domain.MealDomain
import com.example.funday.domain.MealInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val interactor: MealInteractor,
) : ViewModel() {

    lateinit var meals: LiveData<List<MealDomain>>

    init {
        CoroutineScope(Dispatchers.IO + Job()).launch {
            meals = interactor.fetchMeals(MealCategory.BREAKFAST)
        }
    }

    fun changeCategory(category: MealCategory) {
        CoroutineScope(Dispatchers.IO + Job()).launch {
            meals = interactor.fetchMeals(category)
        }
    }

}