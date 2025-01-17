package com.zackmatthews.skeletonproject.domain

/**
 * This class is a model of image and breed data returned by TheCatAPI
 * https://developers.thecatapi.com/view-account/ylX4blBYT9FaoVd6OhvR?report=bOoHBz-8t
 *
 * Example Response:
 *{
 * "id":"0XYvRd7oD",
 * "width":1204,"height":1445,
 * "url":"https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
 * "breeds":[{
 *     "weight":{"imperial":"7  -  10","metric":"3 - 5"},
 *     "id":"abys","name":"Abyssinian",
 *     "temperament":"Active, Energetic, Independent, Intelligent, Gentle",
 *     "origin":"Egypt",
 *     "country_codes":"EG",
 *     "country_code":"EG",
 *     "life_span":"14 - 15",
 *     "wikipedia_url":"https://en.wikipedia.org/wiki/Abyssinian_(cat)"
 * }]
 * }
 */

data class CatModel(
    val id: String? = null,
    val url: String? = null,
    val width: Int,
    val height: Int,
    val breeds: List<CatBreed?>?
)

data class CatBreed(
    val name: String,
    val weight: HashMap<String, String>,
    val temperament: List<String>,
    val origin: String
)