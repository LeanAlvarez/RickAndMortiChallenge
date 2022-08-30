package com.mirai.challengeflow.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.mirai.challengeflow.core.Resource
import com.mirai.challengeflow.repository.DataRepository
import kotlinx.coroutines.Dispatchers

class DataViewModel(private val repo: DataRepository): ViewModel() {

    fun fetchRickAndMortyData(page: Int) = liveData(Dispatchers.IO) {
            emit(Resource.Loading())

            try {
                emit(Resource.Success(repo.getRickAndMortyData(page)))
            }catch (e:Exception){
                emit(Resource.Failure(e))
            }
    }

}

class dataViewModelFactory(val repo: DataRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(DataRepository::class.java).newInstance(repo)
    }
}
