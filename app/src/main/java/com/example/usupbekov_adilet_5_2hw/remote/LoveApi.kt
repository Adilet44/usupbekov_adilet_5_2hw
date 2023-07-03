package com.example.usupbekov_adilet_5_2hw.remote

import android.telecom.Call
import androidx.room.Query
import com.example.usupbekov_adilet_5_2hw.simpleModels.Love
import retrofit2.http.GET
import retrofit2.http.Header

interface LoveApi {
    @GET("getPercentage")
    fun percentageName(
        @Query("name") firstName: String,
        @Query("name") secondName: String,
        @Header("content-type") type: String = "application/octet-stream",
        @Header("X-RapidAPI-Key") key: String = "158156b433msh482908a6bd72323p179207jsncce529ebdcb9",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"

    ): Call<LoveModel>
}