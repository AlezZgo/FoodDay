package com.example.funday.data.cloud

import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApiService {

    @GET("api/json/v1/1/filter.php")
    suspend fun loadData(
        @Query("c") category: String,
    ): MealsCloud
}