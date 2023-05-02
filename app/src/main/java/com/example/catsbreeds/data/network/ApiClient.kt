package com.example.catsbreeds.data.network

import com.example.catsbreeds.data.model.CatModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiClient {
    @Headers("x-api-key: bda53789-d59e-46cd-9bc4-2936630fde39")
    @GET(".")
    suspend fun getCats(): Response<List<CatModel>>
}