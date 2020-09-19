import util.*;
import exception.DukeException;

import java.io.FileNotFoundException;

/**
 * Represents a AllFather chat bot.
 * A task storage system.
 * Supports basic features like todo, list, delete,
 * to do adding, listing and deleting tasks.
 */
public class Duke {

    private DataManager storage;
    private TaskList taskList;
    private TextUi ui;

    /**
     * Constructs AllFather chat bot.
     *
     * @param filePath The data file path in which the tasks are stored.
     */
    public Duke(String filePath) {
        ui = new TextUi();
        storage = new DataManager(filePath);
        try {
            taskList = storage.loadTasks();
            TextUi.printFileLoaded();
        } catch (FileNotFoundException e) {
            TextUi.print(DukeException.EXCEPTION_FILE_LOAD_ERROR);
            taskList = new TaskList();
        }
    }

    /**
     * Starts AllFather and exits when "bye" command is given.
     */
    public void run() {
        CommandUi.CommandInput(taskList);
    }

    public static void main(String[] args) {
        new Duke(TextUi.FILE_PATH).run();
    }
}
