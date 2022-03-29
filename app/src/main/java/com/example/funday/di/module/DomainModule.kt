import com.example.funday.data.MealRepository
import com.example.funday.domain.MealInteractor
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DomainModule {

    @ApplicationScope
    @Binds
    fun bindMealInteractor(impl: MealInteractor.Base): MealInteractor

    companion object {

        @ApplicationScope
        @Provides
        fun provideMealInteractor(
            repository: MealRepository,
        ): MealInteractor.Base {
            return MealInteractor.Base(repository)
        }
    }


}