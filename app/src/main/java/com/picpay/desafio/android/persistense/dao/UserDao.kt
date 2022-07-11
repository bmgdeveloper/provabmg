package com.picpay.desafio.android.persistense.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.android.model.User

@Dao
interface UserDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        @JvmSuppressWildcards
        fun insertAll(list: List<User>)

        @Query("SELECT * FROM users")
        fun getAllUsers(): LiveData<List<User>>

        @Query("DELETE FROM users")
        fun removeAll()
}
