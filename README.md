

# Task Tracker Project

This project is a simple command-line based task tracker that allows you to add, update, delete tasks, and mark them as completed or in progress.

## Steps to Run the Project

### 1. Adding a Task
To add a new task:
`add "description"`

- This will display the newly created task's ID.

### 2. Updating an Existing Task
To update the description of an existing task:
`update <taskid> "<updated description of the task>"`

### 3. Deleting an Existing Task
To delete a task:
`delete <Taskid>`

### 4. Mark a Task as In-Progress
To update the status of a task to "InProgress": `mark-in-progress <TaskID>`

### 5. Mark a Task as Done
To update the status of a task to "Done": `mark-done <TaskID>`

### 6. List All Tasks
To list all tasks: `list`

### 7. List Tasks by Status
To list tasks filtered by their status:
`list <Status>// Done, TODO, InProgress
`
- Valid status values: `Done`, `TODO`, `InProgress`

---

For more information, visit the [project roadmap](https://roadmap.sh/projects/task-tracker).

