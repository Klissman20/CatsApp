package com.example.catsbreeds.domain.model

import com.example.catsbreeds.data.model.CatModel

data class Cat(var id: String, var breedName: String,var origin: String,var affectionLevel: Int,var intelligence: Int, var reference_image_id: String)

fun CatModel.toDomain() = Cat(id, breedName, origin, affectionLevel, intelligence, reference_image_id ?: "")