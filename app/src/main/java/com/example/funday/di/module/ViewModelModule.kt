import androidx.lifecycle.ViewModel
import com.example.funday.presentation.menu.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    fun bindListViewModel(viewModel: MenuViewModel): ViewModel

}