package com.example.taskmanager.Database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TaskDAO {
    @Insert
    fun addTask(task: Task)
}