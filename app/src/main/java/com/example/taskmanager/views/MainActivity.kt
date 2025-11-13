package com.example.taskmanager.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.room.Room
import com.example.taskmanager.Database.Task
import com.example.taskmanager.Database.TaskDAO
import com.example.taskmanager.Database.TaskDataBase
import com.example.taskmanager.TaskAdapter
import com.example.taskmanager.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , TaskAdapter.HandleTaskClick{
    lateinit var binding: ActivityMainBinding

    lateinit var taskAdapter: TaskAdapter
    lateinit var dao: TaskDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataBase = Room.databaseBuilder(
            applicationContext,
            TaskDataBase::class.java,
            "Task_DB"
        ).allowMainThreadQueries().build()

        dao = dataBase.getTaskDAO()

        loadTask()

        binding.BtnFabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddUserActivity::class.java)
            startActivity(intent)

        }
        // Floating action button to add new task
        binding.BtnFabAdd.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddUserActivity::class.java))
        }

        // Search functionality
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { searchTask(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    loadTask() // Show all tasks if search text is empty
                } else {
                    searchTask(newText)
                }
                return true
            }
        })

    }

    private fun loadTask(){
        val task = dao.getAllTask()
        taskAdapter = TaskAdapter(this,task)
        binding.rvTasks.adapter =  taskAdapter
    }

    private fun searchTask(query: String) {
        val searchQuery = "%$query%"
        val filteredTasks = dao.searchTask(searchQuery) // DAO method with LIKE query
        taskAdapter = TaskAdapter(this, filteredTasks)
        binding.rvTasks.adapter = taskAdapter
    }



    override fun onEditClick(task: Task) {
        val editIntent = Intent(this@MainActivity, AddUserActivity::class.java)
        editIntent.putExtra(AddUserActivity.editKey,task)
        startActivity(editIntent)
    }

    override fun onDeleteClick(task: Task) {
        dao.deleteTask(task)
        loadTask()

    }

    override fun onResume() {
        super.onResume()
        loadTask()
    }
}