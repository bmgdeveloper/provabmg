package com.picpay.desafio.android.persistense.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.android.model.User
import com.picpay.desafio.android.persistense.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class DesafioDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DB_NAME = "desafio_db"
    }
}