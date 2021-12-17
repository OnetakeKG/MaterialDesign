package net.nov.materialdesign.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureOfTheDayAPI {

    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey:String):Call<PictureOfTheDayResponseData>
    fun getExplanation (@Query("explanation") explanation:String):Call<PictureOfTheDayResponseData>
}