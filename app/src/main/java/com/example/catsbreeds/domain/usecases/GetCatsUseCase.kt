package com.example.catsbreeds.domain.usecases

import com.example.catsbreeds.data.repository.CatsRepository
import com.example.catsbreeds.domain.model.Cat
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(
    private val repository: CatsRepository
    ){

    suspend operator fun invoke():List<Cat> {
        return repository.getCatsFromApi()
    }
}