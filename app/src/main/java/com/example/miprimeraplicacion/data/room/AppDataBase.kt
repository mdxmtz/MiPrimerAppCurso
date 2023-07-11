package com.example.miprimeraplicacion.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.miprimeraplicacion.data.room.dao.UserDao
import com.example.miprimeraplicacion.data.room.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object{
        const val DATABASE_NAME = "royal_app_db"

        @Volatile
        private var INSTANCE : AppDataBase? = null

        fun getDatabase(context: Context):AppDataBase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE=instance
                instance
            }

        }


    }


}