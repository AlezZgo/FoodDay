package com.example.funday.presentation.menu

import com.example.funday.domain.MealCategory
import java.lang.RuntimeException
import javax.inject.Inject

interface OnTabClickHandler {

    fun handle(position: Int): MealCategory

    class Base@Inject constructor(): OnTabClickHandler{
        override fun handle(position: Int): MealCategory {
            return when (position) {
                0 -> MealCategory.BREAKFAST
                1 -> MealCategory.PASTA
                2 -> MealCategory.SEAFOOD
                3 -> MealCategory.VEGETARIAN
                4 -> MealCategory.DESSERT
                5 -> MealCategory.MISCELLANEOUS
                else -> throw RuntimeException("Unknown meal category type")
            }
        }

    }
}