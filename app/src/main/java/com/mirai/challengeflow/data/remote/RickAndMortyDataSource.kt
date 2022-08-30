package com.mirai.challengeflow.data.remote

import com.mirai.challengeflow.data.model.RickAndMortyList
import com.mirai.challengeflow.repository.WebService

class RickAndMortyDataSource(private val webService: WebService) {

    suspend fun getRickAndMortyData(page: Int): RickAndMortyList =
        webService.getRickAndMortyData(page)


}