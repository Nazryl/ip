import command.*;
import exception.*;
import task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataFileManager {
	public static void loadData() {
		TextUi.printLine();

		try {
			listFileContents(TextUi.FILE_PATH);
			TextUi.printFileLoaded();
		} catch (FileNotFoundException e) {
			TextUi.print(DukeException.EXCEPTION_FILE_LOAD_ERROR);
		}
	}

	public static void listFileContents(String filePath) throws FileNotFoundException {
		File dukeData = new File(filePath);
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
			TextUi.taskList.add(task);

			if (splitArgs[1].equals(String.valueOf(TextUi.BOOLEAN_YES_NUM))) {
				task.markDone();
			}
		}
	}

}
