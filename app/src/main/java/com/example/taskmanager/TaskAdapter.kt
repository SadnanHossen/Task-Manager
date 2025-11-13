package com.example.taskmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.Database.Task
import com.example.taskmanager.databinding.ItemTaskBinding
import com.example.taskmanager.views.MainActivity

class TaskAdapter(val listner : HandleTaskClick, val taskList: List<Task>): RecyclerView.Adapter<TaskAdapter.taskVH>() {

    interface HandleTaskClick{
        fun onEditClick(task:Task)
        fun onDeleteClick(task: Task)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): taskVH {
        return taskVH(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: taskVH,
        position: Int
    ) {
        taskList[position]. let{ task->
            holder.binding.apply {
                tvTitle.text = "${task.title}"
                tvDescription.text = " ${task.description}"
                tvDueDate.text = "Due date : ${task.dueDate}"

                btnEdit.setOnClickListener {
                    listner.onEditClick(task)
                }
                btnDelete.setOnClickListener {
                    listner.onDeleteClick(task)
                }
            }
        }
    }

    override fun getItemCount() = taskList.size

    class taskVH(val binding: ItemTaskBinding): RecyclerView.ViewHolder(binding.root)

}