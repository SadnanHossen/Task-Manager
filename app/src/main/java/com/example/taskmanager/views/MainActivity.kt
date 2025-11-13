package com.example.taskmanager.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.taskmanager.Database.Task
import com.example.taskmanager.Database.TaskDataBase
import com.example.taskmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataBase = Room.databaseBuilder(
            applicationContext,
            TaskDataBase::class.java,
            "Task_DB"
        ).allowMainThreadQueries().build()

        val dao = dataBase.getTaskDAO()



        binding.BtnFabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddUserActivity::class.java)
            startActivity(intent)
            finish()


        }

    }
}