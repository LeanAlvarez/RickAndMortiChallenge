package com.mirai.challengeflow.repository

import com.google.gson.GsonBuilder
import com.mirai.challengeflow.application.AppConstants
import com.mirai.challengeflow.data.model.RickAndMortyList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
   @GET("character/")
   suspend fun getRickAndMortyData(@Query("page") page: Int): RickAndMortyList
}


object RetrofitClient{
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}