package com.picpay.desafio.android.persistense.repository

import com.picpay.desafio.android.model.User
import retrofit2.Response

interface UserRepositoryContract {

    suspend fun getListUser(): Response<List<User>>?
    fun getCacheUser() : Response<List<User>>?
    fun setCachedUser(response: Response<List<User>>)

}