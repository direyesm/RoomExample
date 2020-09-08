package com.example.roomexample

import androidx.lifecycle.LiveData
import com.example.roomexample.database.Task
import com.example.roomexample.database.TaskDao

class TaskRepository(private val mTaskDao: TaskDao) {

    //Este value va a contener todos los datos de la bd
    val listAllTask : LiveData<List<Task>> = mTaskDao.getAllTaskFromDb()

    //Esta funcion va a insertar la info
    suspend fun insertTask(mTask: Task){
        mTaskDao.insertOneTask(mTask)
    }


}