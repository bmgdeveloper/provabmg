package com.picpay.desafio.android.di

import com.picpay.desafio.android.persistense.repository.UserRepository
import com.picpay.desafio.android.persistense.repository.UserRepositoryContract
import org.koin.dsl.module

val repositoryModule = module {

    single { UserRepository(get()) as UserRepositoryContract }

}
