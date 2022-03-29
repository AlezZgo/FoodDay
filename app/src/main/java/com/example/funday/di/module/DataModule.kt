package com.example.funday.di.module

import android.app.Application
import com.example.funday.data.MealRepository
import com.example.funday.data.cache.AppDatabase
import com.example.funday.data.cache.CacheDataSource
import com.example.funday.data.cache.MealDao
import com.example.funday.data.cloud.CloudDataSource
import com.example.funday.di.ApplicationScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindMealRepository(impl: MealRepository.Base): MealRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideMealRepository(
            cacheDataSource: CacheDataSource,
            cloudDataSource: CloudDataSource,
        ): MealRepository.Base {
            return MealRepository.Base(cacheDataSource, cloudDataSource)
        }

        @ApplicationScope
        @Provides
        fun provideCacheDataSource(
            mealDao: MealDao,
        ): CacheDataSource {
            return CacheDataSource.Base(mealDao)
        }


        @ApplicationScope
        @Provides
        fun provideCacheDao(
            application: Application,
        ): MealDao {
            return AppDatabase.instance(application).mealDao()
        }

    }
}