package com.example.catsbreeds.data.model

import com.google.gson.annotations.SerializedName

data class CatModel(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var breedName: String,
    @SerializedName("origin")
    var origin: String,
    @SerializedName("affection_level")
    var affectionLevel: Int,
    @SerializedName("intelligence")
    var intelligence: Int,
    @SerializedName("reference_image_id")
    var imageUrl: String?
)