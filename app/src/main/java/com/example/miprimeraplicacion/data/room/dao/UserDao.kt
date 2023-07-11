package com.example.miprimeraplicacion.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.miprimeraplicacion.data.room.entities.UserEntity

@Dao
interface UserDao {

    @Insert
    //(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(userEntity: UserEntity)


    @Query("SELECT * FROM USER ")
    suspend fun getUsers():List<UserEntity>







}