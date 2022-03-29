import androidx.lifecycle.ViewModel
import com.example.funday.data.MealRepository
import com.example.funday.domain.MealInteractor
import com.example.funday.presentation.menu.MenuViewModel
import com.example.funday.presentation.menu.OnTabClickHandler
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface UiModule {

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    fun bindListViewModel(viewModel: MenuViewModel): ViewModel

    @Binds
    fun bindOnTabClickHandler(interactor: OnTabClickHandler.Base): OnTabClickHandler


}