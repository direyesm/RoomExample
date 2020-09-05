package com.example.roomexample

import com.example.roomexample.database.Task
import com.example.roomexample.database.TaskDao

class TaskRepository(private val mTaskDao: TaskDao) {

    //Este value va a contener todos los datos de la bd
    val listAllTask : List<Task> = mTaskDao.getAllTaskFromDb()

    //Esta funcion va a insertar la info
    fun insertTask(mTask: Task){
        mTaskDao.insertOneTask(mTask)
    }

    
}