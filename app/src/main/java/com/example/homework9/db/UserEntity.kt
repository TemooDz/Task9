package com.example.homework9.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "email") val email: String = "",
    @ColumnInfo(name = "first_name") val firstName: String = "",
    @ColumnInfo(name = "last_name") val lastName: String = ""
)