# ALLFATHER User Guide

## Introduction 
AllFather is a task manager which is used in command-line. Tasks are classified into todo, deadline and event.
AllFather also supports other features like completion, deletion and find of tasks.

## Features 

### Personality
The AllFather has a personality like no other chat bot. He demands the best and upmost tasks to be completed 
for his people to prosper further.

### Display tasks
Viewing of a list of your task.

### Adding tasks
AllFather is classified into three kinds tasks:
1. `todo`
2. `deadline`
3. `event`

One of these task could be added. `deadline` and `event` needs to specify a due date or schedule date respectively.

### Complete tasks
Mark a task as done as complete.

### Delete tasks
Delete a task from the current tasks.

### Search tasks
Searching for tasks given a keyword.

### Save tasks
AllFather has an auto-save feature after every commands given.

### Load tasks
AllFather auto-loads tasks from the previous session.

### Exit
Exit AllFather by typing `bye`.

## Usage

### `list` - Display your current tasks

* Display a list of current task.

* Example of usage: 

    `list`

* Expected outcome:

```
Here are the tasks in your list:
1.[T][Y] read book
2.[D][N] School assignment (by: Nov 23 2020)
3.[E][N] Youth Day (at: Sep 12 2021 12.00AM)
```

### `todo` - Adds todo task

* Add a todo task with a description.

* Example of usage: 

    `todo read book`

* Expected outcome:

```
Got it. I've added this task:
[T][N] read book
Now you have 1 tasks in the list.
```

### `deadline` - Adds deadline task

* Add a deadline task with a description and a due date.

* Example of usage: 

    `deadline School assignment /by 2020-11-23`
    `deadline School assignment /by 2020-11-23 2359`

* Expected outcome:

```
Got it. I've added this task:
[D][N] School assignment (by: Nov 23 2020)
Now you have 2 tasks in the list.
```

### `event` - Adds deadline task

* Add an event task with a description, and a schedule date.

* Example of usage: 

    `event Youth Day /at 2021-09-12`
    `event Youth Day /at 2021-09-12 0000`

* Expected outcome:

```
Got it. I've added this task:
[E][N] Youth Day (at: Sep 12 2021 12.00AM)
Now you have 3 tasks in the list.
```

### `done` - Complete a task

* Complete a specific task given the index.

* Example of usage: 

    `done 1`

* Expected outcome:

```
Nice! I've marked this task as done:
[T][Y] read book
```

### `delete` - Delete a task

* Delete a specific task given the index.

* Example of usage: 

    `delete 2`

* Expected outcome:

```
Done! I've removed this task:
[D][N] School assignment (by: Nov 23 2020)
Now you have 2 tasks in the list.
```

### `find` - Find a task

* Find list of task given the keyword.

* Example of usage: 

    `find oo`

* Expected outcome:

```
Here are the matching tasks in your list:
1.[T][Y] read book
2.[D][N] School assignment (by: Nov 23 2020)
```

### `bye` - Exit AllFather application

* Exit AllFather application

* Example of usage: 

    `bye`

* Expected outcome:
    
    The AllFather GUI closes.
