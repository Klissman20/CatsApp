package com.example.catsbreeds.data.repository


import com.example.catsbreeds.data.model.CatModel
import com.example.catsbreeds.data.network.ApiService
import com.example.catsbreeds.domain.model.Cat
import com.example.catsbreeds.domain.model.toDomain
import javax.inject.Inject

class CatsRepository @Inject constructor(private val api: ApiService) {

    suspend fun getCatsFromApi(): List<Cat> {
        val response: List<CatModel> = api.getCats()
        return response.map { it.toDomain() }
    }
}