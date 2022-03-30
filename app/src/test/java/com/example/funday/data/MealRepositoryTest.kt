package com.example.funday.data

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.example.funday.data.cache.CacheDataSource
import com.example.funday.data.cloud.CloudDataSource
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock


class MealRepositoryTest {
    private val cacheDataSource = CacheDataSource.Test()
    private val cloudDataSource = CloudDataSource.Test()

    @Test
    fun `just my test`(){

    }

    @Test
    fun download() {
    }

    @Test
    fun fetchMeals() {
    }
}



