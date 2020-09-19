package util;

import exception.*;
import task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles loading and saving of tasks from the data file.
 */
public class DataManager {
    private static String filePath;

    /**
     * Initializes a <code>Storage</code> class with the given file path.
     *
     * @param filePath The data file path in which the tasks are stored.
     */
    public DataManager(String filePath) {
        this.filePath = filePath;
        try {
            File fileDirectory = new File(TextUi.FILE_DIR); // Declare folder name

            if (!fileDirectory.exists()) {
                fileDirectory.mkdir();
            }

        } catch (Exception e) {
            TextUi.print(DukeException.EXCEPTION_FILE_LOAD_ERROR);
        }
    }

    /**
     * Loads the tasks from the data file.
     *
     * @return A task list that contains the existing tasks.
     * @throws FileNotFoundException If the data is not found.
     */
    public TaskList loadTasks() throws FileNotFoundException {
        File dukeData = new File(filePath);
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner s = new Scanner(dukeData);
        Task task = null;

        while (s.hasNext()) {
            String[] splitArgs = s.nextLine().split(" \\| ", -1);

            switch (splitArgs[0]) {
            case "T":
                task = new Todo(splitArgs[2]);
                break;
            case "D":
                task = new Deadline(splitArgs[2], splitArgs[3]);
                break;
            case "E":
                task = new Event(splitArgs[2], splitArgs[3]);
                break;
            default:
            }
            taskList.add(task);

            if (splitArgs[1].equals(String.valueOf(TextUi.BOOLEAN_YES_NUM))) {
                task.markDone();
            }
        }
        return new TaskList(taskList);
    }

    /**
     * Converts a single string to be written to the data file.
     *
     * @param taskList The task stored in the arraylists.
     * @return A string of all of the task in data form.
     */
    public static String generateTaskString(ArrayList<Task> taskList) {
        StringBuilder toWrite = new StringBuilder();
        for (Task task : taskList) {
            int statusBool = task.getStatusIcon().equals(TextUi.BOOLEAN_YES) ? TextUi.BOOLEAN_YES_NUM :
                    TextUi.BOOLEAN_NO_NUM;
            String className = task.getClass().getSimpleName().toUpperCase();

            switch (className) {
            case TextUi.COMMAND_TODO:
                toWrite.append(TextUi.TaskType.T + " | " + statusBool + " | " + task.getDescription());
                break;
            case TextUi.COMMAND_DEADLINE:
                Deadline d = (Deadline) task;
                toWrite.append(TextUi.TaskType.D + " | " + statusBool + " | " + task.getDescription() + " | " + d.getDueDate());
                break;
            case TextUi.COMMAND_EVENT:
                Event e = (Event) task;
                toWrite.append(TextUi.TaskType.E + " | " + statusBool + " | " + task.getDescription() + " | " + e.getScheduledDate());
                break;
            default:
            }
            toWrite.append(System.lineSeparator());
        }
        return toWrite.toString();
    }

    /**
     * Save the tasks from the Task list.
     *
     * @param taskList The task stored in the arraylists.
     */
    public static void saveList(ArrayList<Task> taskList) {
        try {
            FileWriter fw = new FileWriter(filePath);
            String toWrite = generateTaskString(taskList);
            fw.write(toWrite);
            fw.close();
        } catch (Exception e) {
            TextUi.print(DukeException.EXCEPTION_FILE_SAVE_ERROR);
        }
    }
}
