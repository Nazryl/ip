package command;

import exception.CommandException;
import task.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandProcess {



	public static void addTask(String commandType, String commandArgs) {
		Task t = null;
		String[] splitArgs;
		CommandVariables.printLine();

		try {
			switch (commandType.toUpperCase()) {
			case CommandVariables.COMMAND_TODO:
				if (commandArgs.equalsIgnoreCase(CommandVariables.COMMAND_TODO)) {
					throw new CommandException("☹ OOPS!!! The description of a todo cannot be empty!");
				} else {
					t = new Todo(commandArgs);
					CommandVariables.taskList.add(t);
				}
				break;
			case CommandVariables.COMMAND_DEADLINE:
				splitArgs = commandArgs.split("/by ", 2);
				if (splitArgs[0].toUpperCase().contains(CommandVariables.COMMAND_DEADLINE)) {
					throw new CommandException("☹ OOPS!!! I need to know your task!");
				} else if (splitArgs[0].contains("/by ") | splitArgs.length < 2) {
					throw new CommandException("☹ OOPS!!! I need to know /by which date!");
				} else {
					t = new Deadline(splitArgs[0], splitArgs[1]);
					CommandVariables.taskList.add(t);
				}
				break;
			case CommandVariables.COMMAND_EVENT:
				splitArgs = commandArgs.split("/at ", 2);
				if (splitArgs[0].toUpperCase().contains(CommandVariables.COMMAND_EVENT)) {
					throw new CommandException("☹ OOPS!!! I need to know your event!");
				} else if (splitArgs[0].contains("/at ") | splitArgs.length < 2) {
					throw new CommandException("☹ OOPS!!! I need to know /at what time!");
				} else {
					t = new Event(splitArgs[0], splitArgs[1]);
					CommandVariables.taskList.add(t);
				}
				break;
			default:
				throw new CommandException("☹ OOPS!!! I'm sorry, give me proper commands!");
			}
			System.out.println("Got it. I've added this task:");
			System.out.println(t);
			System.out.println("Now you have " + CommandVariables.taskList.size() + " tasks in the list.");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void printList(ArrayList<Task> tasks) {
		int index = 0;
		CommandVariables.printLine();
		System.out.println("Here are the tasks in your list:");

		for (Task task : tasks) {
			System.out.println(String.format("%d.", ++index)
					+ task.toString());
		}
	}

	public static void markTask(String commandArgs) {
		int num = Integer.parseInt(commandArgs);
		Task task = CommandVariables.taskList.get(num-1);
		task.markDone();

		CommandVariables.printLine();
		System.out.println("Nice! I've marked this task as done:");
		System.out.println(task);
	}

	public static void CommandInput() {
		Scanner in = new Scanner(System.in);
		String commandInput;

		CommandVariables.printHello();

		loop: while (true) {
			try {
				commandInput = in.nextLine();
				String commandType = commandInput.split(" ")[0];
				String commandArgs = commandInput.substring(commandInput.indexOf(" ") + 1);

				switch (commandType.toUpperCase()) {
				case CommandVariables.COMMAND_TODO:
				case CommandVariables.COMMAND_DEADLINE:
				case CommandVariables.COMMAND_EVENT:
					addTask(commandType, commandArgs);
					break;
				case CommandVariables.COMMAND_LIST:
					printList(CommandVariables.taskList);
					break;
				case CommandVariables.COMMAND_BYE:
					CommandVariables.printBye();
					break loop;
				case CommandVariables.COMMAND_DONE:
					markTask(commandArgs);
					break;
				default:
					throw new CommandException("☹ OOPS!!! Enter for me commands!");
				}
			}
			catch (Exception e) {
				System.out.println("☹ OOPS!!! Enter for me valid commands!");
			}
			CommandVariables.printLine();
		}
	}
}
