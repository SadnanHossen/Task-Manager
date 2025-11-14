
Task Manager App

A simple Android Task Manager application built with Kotlin, Room Database, and RecyclerView.
Users can add, edit, delete, and manage tasks with due dates and completion status.


 Features :

✔ Add new tasks
✔ Edit existing tasks
✔ Delete tasks with confirmation dialog
✔ Mark tasks as completed
✔ Store tasks locally using Room (SQLite)
✔ RecyclerView with custom CardView item
✔ Material UI & Date Picker for due dates
✔ Search tasks 
✔ Smooth, clean, modern UI


 Screenshots :

 <table>
  <tr>
    <th>Home Screen</th>
    <th>Add Task</th>
    <th>Edit Task</th>
    <th>Task Details</th>
    <th>Search</th>
  </tr>
  <tr>
    <td> <img src = "https://github.com/SadnanHossen/Task-Manager/blob/156b92a2598a78a409566debcd87ab55b272cffd/Task%20Manager_main%20ui.jpg" width = "200dp"/></td>
    <td><img src="images/add.jpg" width="200"></td>
    <td><img src="images/edit.jpg" width="200"></td>
    <td><img src="images/details.jpg" width="200"></td>
    <td><img src="images/search.jpg" width="200"></td>
  </tr>
</table>

1. <img src = "https://github.com/SadnanHossen/Task-Manager/blob/156b92a2598a78a409566debcd87ab55b272cffd/Task%20Manager_main%20ui.jpg" width = "200dp"/>
2. <img src = "https://github.com/SadnanHossen/Task-Manager/blob/156b92a2598a78a409566debcd87ab55b272cffd/Task%20Manager_add%20task.jpg" width = "200dp"/>
3. <img src = "https://github.com/SadnanHossen/Task-Manager/blob/156b92a2598a78a409566debcd87ab55b272cffd/Task%20Manager_requeird.jpg" width = "200dp"/>
4. <img src = "https://github.com/SadnanHossen/Task-Manager/blob/156b92a2598a78a409566debcd87ab55b272cffd/Task%20Manager_1st%20task.jpg" width = "200dp"/>
5. <img src = "https://github.com/SadnanHossen/Task-Manager/blob/156b92a2598a78a409566debcd87ab55b272cffd/Task%20Manager_update%20page.jpg" width = "200dp"/>
6. <img src = "https://github.com/SadnanHossen/Task-Manager/blob/156b92a2598a78a409566debcd87ab55b272cffd/Task%20Manager_3%20tasks.jpg" width = "200dp"/>
7. <img src = "https://github.com/SadnanHossen/Task-Manager/blob/156b92a2598a78a409566debcd87ab55b272cffd/Task%20Manager_delete%20task.jpg" width = "200dp"/>
8. <img src = "https://github.com/SadnanHossen/Task-Manager/blob/156b92a2598a78a409566debcd87ab55b272cffd/Task%20Manager_search%20task.jpg" width = "200dp"/>


Screens Included :

1. Task Home (RecyclerView)
2. Add Task Screen
3. Requierd indication
4. Task List
5. Update Task
6. Task List 2
7. Showing Task has been Deleted
8. Searching Task


Tech Stack :

| Component               | Used For                  |
| ----------------------- | ------------------------- |
| **Kotlin**              | Main programming language |
| **Android Room**        | Local database storage    |
| **RecyclerView**        | Displaying task list      |
| **Material Components** | Modern UI                 |
| **ViewBinding**         | Easy UI access            |


 Project Structure :
app/
 ├── data/
 │    ├── Task.kt               # Entity
 │    ├── TaskDao.kt            # DAO
 │    ├── TaskDatabase.kt       # Room Database
 ├── ui/
 │    ├── MainActivity.kt       # Task list
 │    ├── AddEditTaskActivity.kt# Add/Edit screen
 │    ├── TaskAdapter.kt        # RecyclerView adapter
 ├── res/layout/
 │    ├── activity_main.xml
 │    ├── item_task.xml
 │    ├── activity_add_edit_task.xml


Room Database Overview :

1. Task Entity
 Represents a single task with:
   
-title
-description
-dueDate
-isDone

3. DAO

Contains CRUD operations:

-insertTask()
-updateTask()
-deleteTask()
-getAllTasksSortedByDate()

3. Database

Provides a singleton Room instance.


🛠 How to Build & Run

Clone the repository:
[git clone https://github.com/yourusername/task-manager-app.git](https://github.com/SadnanHossen/Task-Manager.git)


Assignment Purpose :

This project demonstrates:

1. Room database implementation

2. RecyclerView usage

3. CRUD operations

4. UI/UX design

5. Data validation

