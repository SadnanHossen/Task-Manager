package com.example.taskmanager.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.room.Room
import com.example.taskmanager.Database.Task
import com.example.taskmanager.Database.TaskDAO
import com.example.taskmanager.Database.TaskDataBase
import com.example.taskmanager.R
import com.example.taskmanager.databinding.ActivityAddUserBinding

@Suppress("DEPRECATION")
class AddUserActivity : AppCompatActivity() {
    companion object{
        const val editKey = "edit"
        const val update = " Update task"
        const val add = " Add task"

    }

    private lateinit var binding: ActivityAddUserBinding
    private lateinit var dao: TaskDAO
    var taskID = 0
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
        if(intent.hasExtra(editKey)){
            binding.btnAddTask.text = update

            val task = intent.getParcelableExtra<Task>(editKey)

            task?.let{
                binding.apply {
                    etTitle.setText(it.title)
                    etDescription.setText(it.description)
                    etDueDate.setText(it.dueDate)
                    taskID = it.id
                }
            }
        }else {
            binding.btnAddTask.text = add
        }

        binding.btnAddTask.setOnClickListener {

            val title = binding.etTitle.text.toString().trim()
            val description = binding.etDescription.text.toString().trim()
            val dueDate = binding.etDueDate.text.toString().trim()

            if (title.isEmpty()){
                binding.etTitle.error = "Title is required "
                binding.etTitle.requestFocus()
                return@setOnClickListener
            }
            if (description.isEmpty()){
                binding.etDescription.error = "Description is required "
                binding.etDescription.requestFocus()
                return@setOnClickListener
            }
            if (dueDate.isEmpty()){
                binding.etDueDate.error = "Due date is required "
                binding.etDueDate.requestFocus()
                return@setOnClickListener
            }

            if(binding.btnAddTask.text.toString()==add){
                addTask(title,description,dueDate)
            }else{
                updateTask(title,description,dueDate)
            }
        }
    }

    private fun updateTask(title: String, description: String, dueDate: String) {
        val updatetask = Task(taskID, title, description, dueDate )
        dao.updateTask(updatetask)
        finish()
    }

    private fun addTask(title: String, description: String, dueDate: String) {
        val task = Task(taskID, title, description, dueDate )
        dao.addTask(task)
        finish()
    }

}