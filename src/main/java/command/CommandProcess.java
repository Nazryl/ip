package command;

import exception.*;
import task.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandProcess {

	public static void CommandInput() {
		Scanner in = new Scanner(System.in);
		String commandInput;

		CommandVariable.printHello();

		loop: while (true) {
			try {
				commandInput = in.nextLine();
				String commandType = commandInput.split(" ")[0];
				String commandArgs = commandInput.substring(commandInput.indexOf(" ") + 1);

				switch (commandType.toUpperCase()) {
				case CommandVariable.COMMAND_TODO:
				case CommandVariable.COMMAND_DEADLINE:
				case CommandVariable.COMMAND_EVENT:
					addTask(commandType, commandArgs);
					break;
				case CommandVariable.COMMAND_LIST:
					printList(CommandVariable.taskList);
					break;
				case CommandVariable.COMMAND_BYE:
					CommandVariable.printBye();
					break loop;
				case CommandVariable.COMMAND_DONE:
					markTask(commandArgs);
					break;
				case CommandVariable.COMMAND_DELETE:
					deleteTask(commandArgs);
					break;
				default:
					throw new CommandException("OOPS!!! Enter for me commands!");
				}
			}
			catch (Exception e) {
				System.out.println("OOPS!!! Enter for me valid commands!");
			}
			CommandVariable.printLine();
		}
	}

	public static void addTask(String commandType, String commandArgs) {
		Task t = null;
		String[] splitArgs;
		CommandVariable.printLine();

		try {
			switch (commandType.toUpperCase()) {
			case CommandVariable.COMMAND_TODO:
				if (commandArgs.equalsIgnoreCase(CommandVariable.COMMAND_TODO)) {
					throw new CommandException("OOPS!!! The description of a todo cannot be empty!");
				} else {
					t = new Todo(commandArgs);
					CommandVariable.taskList.add(t);
				}
				break;
			case CommandVariable.COMMAND_DEADLINE:
				splitArgs = commandArgs.split("/by ", 2);
				if (splitArgs[0].toUpperCase().contains(CommandVariable.COMMAND_DEADLINE)) {
					throw new CommandException("OOPS!!! I need to know your task!");
				} else if (splitArgs[0].contains("/by ") | splitArgs.length < 2) {
					throw new CommandException("OOPS!!! I need to know /by which date!");
				} else {
					t = new Deadline(splitArgs[0], splitArgs[1]);
					CommandVariable.taskList.add(t);
				}
				break;
			case CommandVariable.COMMAND_EVENT:
				splitArgs = commandArgs.split("/at ", 2);
				if (splitArgs[0].toUpperCase().contains(CommandVariable.COMMAND_EVENT)) {
					throw new CommandException("OOPS!!! I need to know your event!");
				} else if (splitArgs[0].contains("/at ") | splitArgs.length < 2) {
					throw new CommandException("OOPS!!! I need to know /at what time!");
				} else {
					t = new Event(splitArgs[0], splitArgs[1]);
					CommandVariable.taskList.add(t);
				}
				break;
			default:
				throw new CommandException("OOPS!!! I'm sorry, give me proper commands!");
			}
			System.out.println("Got it. I've added this task:");
			System.out.println(t);
			System.out.println("Now you have " + CommandVariable.taskList.size() + " tasks in the list.");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void deleteTask(String commandArgs) {
		int num = Integer.parseInt(commandArgs);
		try {
			Task task = CommandVariable.taskList.get(num-1);
			CommandVariable.taskList.remove(task);

			CommandVariable.printLine();
			System.out.println("Done! I've removed this task:");
			System.out.println(task);
			System.out.println("Now you have " + CommandVariable.taskList.size() + " tasks in the list.");
		} catch (Exception e) {
			CommandVariable.printLine();
			System.out.println("OOPS!!! Enter a valid task to delete!");
		}
	}

	public static void printList(ArrayList<Task> tasks) {
		int index = 0;
		CommandVariable.printLine();
		System.out.println("Here are the tasks in your list:");

		for (Task task : tasks) {
			System.out.println(String.format("%d.", ++index)
					+ task.toString());
		}
	}

	public static void markTask(String commandArgs) {
		int num = Integer.parseInt(commandArgs);
		Task task = CommandVariable.taskList.get(num-1);
		task.markDone();

		CommandVariable.printLine();
		System.out.println("Nice! I've marked this task as done:");
		System.out.println(task);
	}

}
