package command;

import task.*;

import java.util.ArrayList;

public class TextUi {
	public static final String COMMAND_TODO = "TODO";
	public static final String COMMAND_DEADLINE = "DEADLINE";
	public static final String COMMAND_EVENT = "EVENT";
	public static final String COMMAND_LIST = "LIST";
	public static final String COMMAND_BYE = "BYE";
	public static final String COMMAND_DONE = "DONE";
	public static final String COMMAND_DELETE = "DELETE";
	public static final String BOOLEAN_YES = "Y";
	public static final String BOOLEAN_NO = "N";
	public static final String FILE_PATH = "data/duke.txt";
	public static final String FILE_DIR = "data";
	public static final int BOOLEAN_YES_NUM = 1;
	public static final int BOOLEAN_NO_NUM = 0;
	public static final ArrayList<Task> taskList = new ArrayList<>();

	public enum TaskType {
		D, E, T
	}

	public static void printHello() {
		printLine();
		print("Greetings Peasants! I'm the Almighty Allfather!");
		print("What can I do for you today?");
		printLine();
	}

	public static void printBye() {
		printLine();
		print("Begone!");
	}

	public static void printLine() {
		print("____________________________________________________________");
	}

	public static void print(String s) {
		System.out.println(s);
	}

	public static void printFileLoaded() {
		print("Duke file loaded!");
	}

}
