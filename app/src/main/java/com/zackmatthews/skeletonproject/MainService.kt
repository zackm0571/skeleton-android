package com.zackmatthews.skeletonproject

import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {
    @GET("v1/images/search")
    suspend fun getImages(@Query("limit") limit: Int): List<CatModel>
}