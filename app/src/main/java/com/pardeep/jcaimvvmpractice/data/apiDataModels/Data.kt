package com.pardeep.jcaimvvmpractice.data.apiDataModels

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("color") val color: String? = null,
    @SerializedName("Color") val colorAlt: String? = null,
    @SerializedName("capacity") val capacity: String? = null,
    @SerializedName("Capacity") val capacityAlt: String? = null,
    @SerializedName("capacity GB") val capacityGB: Int? = null,
    @SerializedName("price") val price: Double? = null,
    @SerializedName("Price") val priceLabel: String? = null,
    @SerializedName("generation") val generation: String? = null,
    @SerializedName("Generation") val generationAlt: String? = null,
    @SerializedName("year") val year: Int? = null,
    @SerializedName("CPU model") val cpuModel: String? = null,
    @SerializedName("Hard disk size") val hardDiskSize: String? = null,
    @SerializedName("Screen size") val screenSize: Double? = null,
    @SerializedName("Strap Colour") val strapColour: String? = null,
    @SerializedName("Case Size") val caseSize: String? = null,
    @SerializedName("Description") val description: String? = null

)