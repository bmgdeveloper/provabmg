package com.picpay.desafio.android.di

import androidx.room.Room
import com.picpay.desafio.android.persistense.database.DesafioDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            DesafioDataBase::class.java,
            DesafioDataBase.DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { (get() as DesafioDataBase).userDao() }

}