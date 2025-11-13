package com.example.taskmanager.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val dueDate: String
)