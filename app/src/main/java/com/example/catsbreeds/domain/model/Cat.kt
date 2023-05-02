package com.example.catsbreeds.domain.model

import com.example.catsbreeds.data.model.CatModel

data class Cat(var id: Int, var breedName: String,var origin: String,var affectionLevel: Int,var intelligence: Int,var imageUrl: String)


fun CatModel.toDomain() = Cat(id, breedName, origin, affectionLevel, intelligence, imageUrl)