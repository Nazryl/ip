import util.*;
import exception.DukeException;

import java.io.FileNotFoundException;

public class Duke {

    private DataManager storage;
    private TaskList taskList;
    private TextUi ui;

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

    public void run() {
        CommandUi.CommandInput(taskList);
    }

    public static void main(String[] args) {
        new Duke(TextUi.FILE_PATH).run();
    }
}
