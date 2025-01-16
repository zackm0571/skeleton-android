package com.zackmatthews.skeletonproject

import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {
    private val MIN_SIZE = 480
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com")
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()

    val catService = retrofit.create(MainService::class.java)

    fun getCats(numItems: Int) = flow<List<CatModel>> {
        emit(catService.getImages(numItems).filter { it.width >  MIN_SIZE && it.height > MIN_SIZE})
    }
}