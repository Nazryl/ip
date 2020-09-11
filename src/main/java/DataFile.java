import command.*;
import task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataFile {
	public static void loadData() {
		CommandVariable.printLine();
		try {
			listFileContents("data/duke.txt");
			System.out.println("Duke file loaded!");
		} catch (FileNotFoundException e) {
			System.out.println("Duke file not found!");
		}
	}

	private static void listFileContents(String filePath) throws FileNotFoundException {
		File dukeData = new File(filePath); // create a File for the given file path
		Scanner s = new Scanner(dukeData); // create a Scanner using the File as the source
		Task t = null;

		while (s.hasNext()) {
			String[] splitArgs = s.nextLine().split(" \\| ", -1);

			switch (splitArgs[0]) {
			case "T":
				t = new Todo(splitArgs[2]);
				break;
			case "D":
				t = new Deadline(splitArgs[2], splitArgs[3]);
				break;
			case "E":
				t = new Event(splitArgs[2], splitArgs[3]);
				break;
			default:
			}
			CommandVariable.taskList.add(t);

			if (splitArgs[1].equals("1")) {
				t.markDone();
			}
		}
	}

}
