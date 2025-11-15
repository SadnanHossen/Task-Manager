
/**
 * TaskAdapter is a RecyclerView adapter responsible for displaying a list of Task objects.
 * Each item shows the task's title, description, and due date, along with Edit and Delete buttons.
 *
 * @param listener An implementation of HandleTaskClick to handle edit and delete actions for tasks.
 * @param taskList The list of Task objects to display in the RecyclerView.
 *
 * Usage:
 * 1. Implement the HandleTaskClick interface in your Activity/Fragment.
 * 2. Pass the listener and the list of tasks when initializing the adapter.
 * 3. Set the adapter to your RecyclerView.
 *
 * This adapter follows the standard RecyclerView pattern:
 * - onCreateViewHolder inflates the item layout.
 * - onBindViewHolder binds task data to each item view.
 * - getItemCount returns the size of the task list.
 */
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
        //show , edit and delete handle tasks button action
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
// end