package com.example.funday.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.funday.data.cache.CacheDataSource
import com.example.funday.data.cache.MealCache
import com.example.funday.data.cloud.CloudDataSource
import com.example.funday.data.cloud.MealCloud
import com.example.funday.data.cloud.MealsCloud
import com.example.funday.domain.MealCategory
import com.example.funday.domain.MealDomain
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test


class MealRepositoryTest {

    @Test
    fun `test if cache is empty`() {
        runBlocking {
            val emptyCacheDataSource = TestCacheDataSource()
            val cloudDataSource = TestCloudDataSource()
            val repository = MealRepository.Base(emptyCacheDataSource, cloudDataSource)
            repository.downloadIfCacheIsEmpty()
            val actual = repository.fetchMeals(category = MealCategory.BREAKFAST).value
            val expected = MutableLiveData(listOf(
                MealCloud("Burger","http://www.appletozucchini.com.au/wp-content/uploads/2016/08/mcdonalds-Cheeseburger.png",12201),
                MealCloud("Pizza","https://vicinipizza.webnode.mx/_files/system_preview_small_200000000-9ddfe9fd3f-public/pizza-slice.jpg",12202),
                MealCloud("Kebab","https://mammamiapizzakebab.webnode.cz/_files/system_preview_small_200000006-479d048946-public/durum.jpg",12203)
            )).value

            assertEquals(expected,actual)
        }
    }

    class TestCacheDataSource : CacheDataSource {
        private var list = MutableLiveData<List<MealCache>>()

        override fun fetchMeals(category: MealCategory): LiveData<List<MealCache>> {
            return list
        }

        override suspend fun insertMeal(mealCache: MealCache) {
            list = MutableLiveData<List<MealCache>>(list.value?.plus(mealCache))
        }

        override suspend fun cacheIsEmpty(): Boolean {
            val size = list.value?.size ?: 0
            return size <= 0
        }

    }
}

class TestCloudDataSource: CloudDataSource {
    override suspend fun downloadMeals(category: MealCategory): MealsCloud {
        return MealsCloud(listOf(
            MealCloud("Burger","http://www.appletozucchini.com.au/wp-content/uploads/2016/08/mcdonalds-Cheeseburger.png",12201),
            MealCloud("Pizza","https://vicinipizza.webnode.mx/_files/system_preview_small_200000000-9ddfe9fd3f-public/pizza-slice.jpg",12202),
            MealCloud("Kebab","https://mammamiapizzakebab.webnode.cz/_files/system_preview_small_200000006-479d048946-public/durum.jpg",12203)
        ))
    }
}





