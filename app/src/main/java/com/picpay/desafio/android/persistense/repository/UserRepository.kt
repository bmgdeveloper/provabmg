package com.picpay.desafio.android.persistense.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.model.User
import com.picpay.desafio.android.persistense.dao.UserDao
import com.picpay.desafio.android.service.PicPayService
import retrofit2.Response

class UserRepository (
    private var picPayService: PicPayService
) : UserRepositoryContract {

    private val  _cachedListUser = MutableLiveData<Response<List<User>>>()

    override suspend fun getListUser(): Response<List<User>>? {
        return picPayService.getUsers()
    }

    override fun setCachedUser(response: Response<List<User>>){
        _cachedListUser.value  = response
    }

    override fun getCacheUser() : Response<List<User>>? = _cachedListUser.value



}