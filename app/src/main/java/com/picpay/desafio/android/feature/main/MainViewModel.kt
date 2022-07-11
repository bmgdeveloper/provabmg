package com.picpay.desafio.android.feature.main

import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.base.BaseViewModel
import com.picpay.desafio.android.model.User
import com.picpay.desafio.android.persistense.repository.UserRepositoryContract

class MainViewModel(
        private val userRepository: UserRepositoryContract
    ) : BaseViewModel() {

    val users = MutableLiveData<List<User>?>()
    val errorMessage = MutableLiveData<String>()

    fun getListUser() {
        coroutineScope {
            val cacheUser = userRepository.getCacheUser()
            if(cacheUser?.body() != null){
                users.postValue(cacheUser?.body())
            } else {
                val response = userRepository.getListUser()
                if (response!!.isSuccessful) {
                    users.postValue(response.body())
                    userRepository.setCachedUser(response)
                } else {
                    errorMessage.postValue(response.errorBody()?.string())
                }
            }
        }
    }

    }

