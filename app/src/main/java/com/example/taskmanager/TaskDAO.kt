package com.example.taskmanager

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TaskDAO {
    @Insert
    fun addTask(task: Task)
}