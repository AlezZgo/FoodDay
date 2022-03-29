package com.example.funday.presentation.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
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

    var meals: LiveData<List<MealDomain>>
    var filter = MutableLiveData(MealCategory.BREAKFAST)

    init {
        CoroutineScope(Dispatchers.IO + Job()).launch {
            interactor.download()
        }
        meals = Transformations.switchMap(filter) { filter ->
            interactor.fetchMeals(filter)
        }

    }

    fun setFilter(newFilter: MealCategory) {
        filter.postValue(newFilter)
    }

}