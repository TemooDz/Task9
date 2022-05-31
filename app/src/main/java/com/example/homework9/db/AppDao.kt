package com.example.homework9.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: Array<UserEntity>)

    @Query("SELECT * FROM userentity")
    fun loadAllUsers(): Array<UserEntity>

    @Query("DELETE FROM `userentity` WHERE `id` > 9")
    fun delete()
}
