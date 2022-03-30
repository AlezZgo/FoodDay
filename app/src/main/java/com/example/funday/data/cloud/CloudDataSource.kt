package com.example.funday.data.cloud

import com.example.funday.domain.MealCategory
import javax.inject.Inject

interface CloudDataSource {

    suspend fun downloadMeals(
        category: MealCategory,
    ): MealsCloud

    class Base @Inject constructor(private val service: MealsApiService) : CloudDataSource {
        override suspend fun downloadMeals(category: MealCategory): MealsCloud {
            return service.loadData(category.toString())
        }
    }
    class Test: CloudDataSource {
        override suspend fun downloadMeals(category: MealCategory): MealsCloud {
            return MealsCloud(listOf(
                MealCloud("Burger","http://www.appletozucchini.com.au/wp-content/uploads/2016/08/mcdonalds-Cheeseburger.png",12201),
                MealCloud("Pizza","https://vicinipizza.webnode.mx/_files/system_preview_small_200000000-9ddfe9fd3f-public/pizza-slice.jpg",12202),
                MealCloud("Kebab","https://mammamiapizzakebab.webnode.cz/_files/system_preview_small_200000006-479d048946-public/durum.jpg",12203)
            ))
        }
    }

}