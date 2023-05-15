package com.example.catsbreeds.data.network

import com.example.catsbreeds.data.model.CatModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("breeds")
    suspend fun getCats(): Response<List<CatModel>>

}