
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
   <th>Add task</th>
   <th>Requierd indication</th>
  
   <th>Task list</th>
    <th>Update task</th>
    <th>Task list </th>
    <th>Task list after deleted</th>
    <th>Searching task</th>
  </tr>
  <tr>
    <td> <img src = "Images/Task Manager_main ui.jpg" width = "200dp"/></td>
    <td><img src="Images/Task Manager_add task.jpg" width="200"></td>
    <td><img src="Images/Task Manager_requeird.jpg" width="200"></td>
    <td><img src="Images/Task Manager_1st task.jpg" width="200"></td>
    <td><img src="Images/Task Manager_update page.jpg" width="200"></td>
   <td><img src="Images/Task Manager_3 tasks.jpg" width="200"></td>
   <td><img src="Images/Task Manager_delete task.jpg" width="200"></td>
   <td><img src="Images/Task Manager_search task.jpg" width="200"></td>
  </tr>
</table>


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


 Project Structure:  <br>
app/ <br>
 ├── data/ <br>
 │    ├── Task.kt               # Entity <br>
 │    ├── TaskDao.kt            # DAO <br>
 │    ├── TaskDatabase.kt       # Room Database <br>
 ├── ui/ <br>
 │    ├── MainActivity.kt       # Task list <br>
 │    ├── AddEditTaskActivity.kt# Add/Edit screen <br>
 │    ├── TaskAdapter.kt        # RecyclerView adapter <br>
 ├── res/layout/ <br>
 │    ├── activity_main.xml <br>
 │    ├── item_task.xml <br>
 │    ├── activity_add_edit_task.xml <br>
 

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

