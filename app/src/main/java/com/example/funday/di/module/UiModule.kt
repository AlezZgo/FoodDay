package com.example.funday.di.module

import androidx.lifecycle.ViewModel
import com.example.funday.di.ViewModelKey
import com.example.funday.presentation.menu.MenuViewModel
import com.example.funday.presentation.menu.OnTabClickHandler
import dagger.Binds
import dagger.Module
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