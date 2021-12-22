package net.nov.materialdesign.repository

import com.google.gson.annotations.SerializedName

data class PictureOfTheDayResponseData(
    @field:SerializedName("copyright") val copyright: String?,
    @field:SerializedName("date") val date: String?,
    @field:SerializedName("explanation") val explanation: String?,
    @field:SerializedName("media_type") val mediaType: String?,
    @field:SerializedName("title") val title: String?,
    @field:SerializedName("url") val url: String?,
    @field:SerializedName("hdurl") val hdurl: String?,


    val identifier: String,
    val caption: String,
    val image: String,
    val version: String,
    val date1: String

)