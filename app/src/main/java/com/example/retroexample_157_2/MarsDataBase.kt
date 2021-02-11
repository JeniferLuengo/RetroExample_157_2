package com.example.retroexample_157_2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retroexample_157_2.model.remote.MarsRealState


@Database(entities =[MarsRealState::class], version=1)
abstract class MarsDataBase : RoomDatabase() {

    abstract fun getMarsDao(): MarsDao
    companion object{
        @Volatile
        private var Instance: MarsDataBase? =null

        fun getDataBase(context: Context): MarsDataBase{
            val tempInstance = Instance
            if(tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder( context.applicationContext,
                    MarsDataBase::class.java, "Mars_db").build()
                Instance= instance
                return instance
            }
        }
    }
}