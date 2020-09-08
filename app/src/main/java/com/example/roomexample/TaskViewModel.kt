package com.example.roomexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomexample.database.Task
import com.example.roomexample.database.TaskDataBase
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application){

    private val repository: TaskRepository
    val allTask: LiveData<List<Task>>

    init {
        val taskDao = TaskDataBase.getDatabase(application).getTaskDao()
        repository = TaskRepository(taskDao)
        allTask = repository.listAllTask
    }

    fun insertTask(task: Task) = viewModelScope.launch{
        repository.insertTask(task)
    }

    fun deleteAllTask() = viewModelScope.launch{
        repository.deleteAll()
    }
}