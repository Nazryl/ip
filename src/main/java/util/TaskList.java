package util;

import task.Task;

import java.util.ArrayList;

/**
 * Stores the list of tasks and supports tasks such as getTask, addTask and removeTask.
 */
public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    public Task getTask(int index) {
        return taskList.get(index - 1);
    }

    public int getSize() {
        return taskList.size();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(int task) {
        taskList.remove(task - 1);
    }
}
