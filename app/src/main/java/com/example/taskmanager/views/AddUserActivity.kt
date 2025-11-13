/**
 * AddUserActivity handles adding a new task or editing an existing task in the Task Manager app.
 *
 * Features:
 * - If launched with an existing task (via intent), pre-fills the form for editing.
 * - Validates user input for title, description, and due date.
 * - Uses Room database (TaskDAO) for adding or updating tasks.
 *
 * Intent extras:
 * - "edit" -> Task object to be edited
 *
 * Buttons:
 * - btnAddTask: Adds a new task or updates an existing one depending on context.
 */

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

        // Initialize Room database and DAO
        val dataBase = Room.databaseBuilder(
            applicationContext,
            TaskDataBase::class.java,
            "Task_DB"
        ).allowMainThreadQueries().build()
        dao = dataBase.getTaskDAO()

        // Check if this activity is launched to edit an existing task
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

        // Handle Add/Update button click
        binding.btnAddTask.setOnClickListener {

            val title = binding.etTitle.text.toString().trim()
            val description = binding.etDescription.text.toString().trim()
            val dueDate = binding.etDueDate.text.toString().trim()

            // Input validation
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


            // Add or update task based on button text
            if(binding.btnAddTask.text.toString()==add){
                addTask(title,description,dueDate)
            }else{
                updateTask(title,description,dueDate)
            }
        }
    }

    // Close activity and return to previous screen after update and add tasks
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