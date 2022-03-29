import MealCache
import MealDao
import androidx.lifecycle.LiveData

interface CacheDataSource {
    fun fetchMeals(): LiveData<List<MealCache>>

    suspend fun insertMeal(mealCache: MealCache)

    suspend fun cacheIsEmpty(): Boolean

    class Base(private val mealDao: MealDao) : CacheDataSource {
        override fun fetchMeals(): LiveData<List<MealCache>> {
            return mealDao.list()
        }

        override suspend fun insertMeal(meal: MealCache) {
            mealDao.insert(meal)
        }

        override suspend fun cacheIsEmpty(): Boolean {
            return mealDao.count()<=0
        }

    }
}