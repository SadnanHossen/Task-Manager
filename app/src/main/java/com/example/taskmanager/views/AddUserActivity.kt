package com.example.taskmanager.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.taskmanager.Database.Task
import com.example.taskmanager.Database.TaskDAO
import com.example.taskmanager.Database.TaskDataBase
import com.example.taskmanager.R
import com.example.taskmanager.databinding.ActivityAddUserBinding

class AddUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddUserBinding
    private lateinit var dao: TaskDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataBase = Room.databaseBuilder(
            applicationContext,
            TaskDataBase::class.java,
            "Task_DB"
        ).allowMainThreadQueries().build()

        dao = dataBase.getTaskDAO()

        binding.btnAddTask.setOnClickListener {

            val title = binding.etTitle.text.toString().trim()
            val description = binding.etDescription.text.toString().trim()
            val dueDate = binding.etDueDate.text.toString().trim()

            addTask(title,description,dueDate)
        }
    }

    private fun addTask(title: String, description: String, dueDate: String) {

        val task = Task(0, title, description, dueDate )

        dao.addTask(task)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}