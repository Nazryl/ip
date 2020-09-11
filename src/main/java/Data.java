import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data {
	public static void loadData() {
		try {
			printFileContents("data/duke.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Duke data not found");
		}
	}

	private static void printFileContents(String filePath) throws FileNotFoundException {
		File dukeData = new File(filePath); // create a File for the given file path
		Scanner s = new Scanner(dukeData); // create a Scanner using the File as the source
		while (s.hasNext()) {
			System.out.println(s.nextLine());
		}
	}
}
