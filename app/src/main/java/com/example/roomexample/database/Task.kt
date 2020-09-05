package com.example.roomexample.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_task")
data class Task (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int,
    val task: String,
    val completeTask: Boolean)