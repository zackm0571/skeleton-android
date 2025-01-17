package com.zackmatthews.skeletonproject.data

import com.zackmatthews.skeletonproject.domain.CatModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {
    @GET("v1/images/search")
    suspend fun getImages(@Query("limit") limit: Int): List<CatModel>
}