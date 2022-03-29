import com.example.funday.data.cloud.MealsCloud
import com.example.funday.domain.MealCategory

interface CloudDataSource {

    suspend fun downloadMeals(
        category: MealCategory,
    ): MealsCloud

    class Base(private val service: MealsApiService) : CloudDataSource {
        override suspend fun downloadMeals(category: MealCategory): MealsCloud {

            return service.loadData(category.toString())
        }

    }

}