package com.mirai.challengeflow.repository

import com.mirai.challengeflow.data.model.RickAndMortyList
import com.mirai.challengeflow.data.remote.RickAndMortyDataSource

class DataRepositoryImpl(private val dataSource: RickAndMortyDataSource): DataRepository {
    override suspend fun getRickAndMortyData(page:Int): RickAndMortyList = dataSource.getRickAndMortyData(page)

}