package command;

import task.Task;

import java.util.ArrayList;

public class CommandVariable {
	public static final String COMMAND_TODO = "TODO";
	public static final String COMMAND_DEADLINE = "DEADLINE";
	public static final String COMMAND_EVENT = "EVENT";
	public static final String COMMAND_LIST = "LIST";
	public static final String COMMAND_BYE = "BYE";
	public static final String COMMAND_DONE = "DONE";
	public static final String BOOLEAN_YES = "Y";
	public static final String BOOLEAN_NO = "N";
	public static final ArrayList<Task> taskList = new ArrayList<>();

	public enum TaskType {
		D, E, T
	}

	public static void printHello() {
		printLine();
		System.out.println("Greetings Peasants! I'm the Almighty Allfather!");
		System.out.println("What can I do for you today?");
		printLine();
	}

	public static void printBye() {
		printLine();
		System.out.println("Begone!");
		printLine();
	}

	public static void printLine() {
		System.out.println("____________________________________________________________");
	}
}
