package com.mirai.challengeflow.repository

import com.mirai.challengeflow.data.model.RickAndMortyList

interface DataRepository {
    suspend fun getRickAndMortyData(page: Int): RickAndMortyList
}