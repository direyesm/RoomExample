package com.example.roomexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATA_BASE_NAME = "Task_db"


@Database(entities = [Task::class], version = 1)
abstract class TaskDataBase : RoomDatabase() {

    //aca van los dao
    abstract fun getTaskDao(): TaskDao

    companion object{
        @Volatile
        private var INSTANCE: TaskDataBase? = null

        fun getDatabase(context: Context): TaskDataBase {
            val tempInstances =  INSTANCE
            if(tempInstances != null){
                return tempInstances
            }

            synchronized(this){
                val instance = Room.databaseBuilder(context, TaskDataBase::class.java, DATA_BASE_NAME).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}