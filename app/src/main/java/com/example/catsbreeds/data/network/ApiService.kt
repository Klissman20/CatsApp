package com.example.catsbreeds.data.network

import com.example.catsbreeds.data.model.CatModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(private val api: ApiClient){
    suspend fun getCats(): List<CatModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getCats()
            response.body()?: emptyList()
        }
    }
}