import android.app.Application
import com.example.funday.core.FoodDayApp
import com.example.funday.presentation.BasketFragment
import com.example.funday.presentation.MainActivity
import com.example.funday.presentation.ProfileFragment
import com.example.funday.presentation.menu.MenuFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        UiModule::class,
        DomainModule::class,
        NetModule::class,
    ]
)

interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(menuFragment: MenuFragment)

    fun inject(profileFragment: ProfileFragment)

    fun inject(basketFragment: BasketFragment)

    fun inject(application: FoodDayApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application,
        ): ApplicationComponent
    }
}
