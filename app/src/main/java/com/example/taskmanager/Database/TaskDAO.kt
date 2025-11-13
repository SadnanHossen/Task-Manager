package com.example.taskmanager.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDAO {
    @Insert
    fun addTask(task: Task)
    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM Task_table WHERE title LIKE :searchQuery")
    fun searchTask(searchQuery: String): List<Task>

    @Query("SELECT * FROM Task_table")
    fun getAllTask(): List<Task>
}