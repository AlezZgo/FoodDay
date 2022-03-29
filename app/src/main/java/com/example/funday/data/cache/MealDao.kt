import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(qrCode: MealCache)

    @Query("SELECT * FROM meals ORDER BY name ASC")
    fun list(): LiveData<List<MealCache>>

    @Query("SELECT count(*) FROM meals")
    suspend fun count(): Int

}