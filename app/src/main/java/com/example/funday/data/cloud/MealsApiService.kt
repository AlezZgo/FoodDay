import com.example.funday.data.cloud.MealsCloud
import okhttp3.MultipartBody
import retrofit2.http.*

interface MealsApiService {

    @GET("api/json/v1/1/filter.php")
    suspend fun loadData(
        @Query("c") category: String,
    ): MealsCloud
}