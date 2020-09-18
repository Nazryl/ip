package util;

import exception.*;
import task.*;

import java.util.ArrayList;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class CommandUi {

    public static void CommandInput(TaskList taskList) {
        Scanner in = new Scanner(System.in);
        String commandInput = null;
        TextUi.printHello();

        do {
            try {
                commandInput = in.nextLine();
                String[] commandArgs = commandInput.split(" ", 2);

                switch (commandArgs[0].toUpperCase()) {
                case TextUi.COMMAND_TODO:
                case TextUi.COMMAND_DEADLINE:
                case TextUi.COMMAND_EVENT:
                    addTask(taskList, commandArgs[0], commandArgs[1]);
                    break;
                case TextUi.COMMAND_LIST:
                    printList(taskList);
                    break;
                case TextUi.COMMAND_BYE:
                    TextUi.printBye();
                    commandInput = commandArgs[0].toUpperCase();
                    break;
                case TextUi.COMMAND_DONE:
                    markTask(taskList, commandArgs[1]);
                    break;
                case TextUi.COMMAND_DELETE:
                    deleteTask(taskList, commandArgs[1]);
                    break;
                case TextUi.COMMAND_FIND:
                    findTask(taskList, commandArgs[1]);
                    break;
                case "":
                    throw new CommandException(DukeException.EXCEPTION_MISSING_COMMANDS);
                default:
                    throw new CommandException(DukeException.EXCEPTION_INVALID_COMMANDS);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                TextUi.printLine();
                TextUi.print(DukeException.EXCEPTION_MISSING_TASK);
            } catch (Exception e) {
                TextUi.printLine();
                TextUi.print(e.toString());
            }
            TextUi.printLine();

            DataManager.saveList(taskList.getTasks());

        } while (!TextUi.COMMAND_BYE.equals(commandInput));
    }

    public static void addTask(TaskList taskList, String commandType, String commandArgs) {
        Task task = null;
        String[] splitArgs;
        TextUi.printLine();

        try {
            switch (commandType.toUpperCase()) {
            case TextUi.COMMAND_TODO:
                if (commandArgs.isEmpty()) {
                    throw new CommandException(DukeException.EXCEPTION_MISSING_TASK);
                } else {
                    task = new Todo(commandArgs);
                    taskList.addTask(task);
                }
                break;
            case TextUi.COMMAND_DEADLINE:
                splitArgs = commandArgs.split(" /by ", 2);
                if (splitArgs[0].toUpperCase().contains(TextUi.COMMAND_DEADLINE)) {
                    throw new CommandException(DukeException.EXCEPTION_MISSING_TASK);
                } else if (splitArgs[0].contains("/by ") | splitArgs.length < 2) {
                    throw new CommandException(DukeException.EXCEPTION_MISSING_DATE);
                } else {
                    task = new Deadline(splitArgs[0], splitArgs[1]);
                    taskList.addTask(task);
                }
                break;
            case TextUi.COMMAND_EVENT:
                splitArgs = commandArgs.split(" /at ", 2);
                if (splitArgs[0].toUpperCase().contains(TextUi.COMMAND_EVENT)) {
                    throw new CommandException(DukeException.EXCEPTION_MISSING_EVENT);
                } else if (splitArgs[0].contains("/at ") | splitArgs.length < 2) {
                    throw new CommandException(DukeException.EXCEPTION_MISSING_TIME);
                } else {
                    task = new Event(splitArgs[0], splitArgs[1]);
                    taskList.addTask(task);
                }
                break;
            default:
                throw new CommandException(DukeException.EXCEPTION_INVALID_COMMANDS);
            }
            TextUi.print("Got it. I've added this task:");
            System.out.println(task);
            TextUi.print("Now you have " + taskList.getSize() + " tasks in the list.");
        } catch (DukeException e) {
            TextUi.print(e.toString());
        }
    }

    /**
     * Lists out all tasks in the taskList.
     * @param taskList The task stored in the arraylists.
     */
    public static void printList(TaskList taskList) {
        int index = 0;
        TextUi.printLine();
        TextUi.print("Here are the tasks in your list:");

        for (Task task : taskList.getTasks()) {
            TextUi.print(String.format("%d.", ++index)
                    + task.toString());
        }
    }

    /**
     * Deletes task in the taskList.
     * @param taskList The task stored in the arraylists.
     * @param commandArgs The index of the task to be deleted.
     */
    public static void deleteTask(TaskList taskList, String commandArgs) throws DukeException {
        int num = Integer.parseInt(commandArgs);
        Task task = null;

        try {
            task = taskList.getTask(num);
            taskList.removeTask(num);

        } catch (Exception e) {
            throw new DukeException(DukeException.EXCEPTION_INVALID_DELETE);
        }

        TextUi.printLine();
        TextUi.print("Done! I've removed this task:");
        System.out.println(task);
        TextUi.print("Now you have " + taskList.getSize() + " tasks in the list.");
    }

    /**
     * Marks a task in the taskList as done.
     * @param taskList The task stored in the arraylists.
     * @param commandArgs The index of the task to be deleted.
     */
    public static void markTask(TaskList taskList, String commandArgs) throws DukeException {
        int num = Integer.parseInt(commandArgs);
        Task task = null;

        try {
            task = taskList.getTask(num);
            task.markDone();
        } catch (Exception e) {
            throw new DukeException(DukeException.EXCEPTION_MARK_ERROR);
        }

        TextUi.printLine();
        TextUi.print("Nice! I've marked this task as done:");
        System.out.println(task);
    }

    /**
     * Finds a task in the taskList as done.
     * @param taskList The task stored in the arraylists.
     * @param commandArgs The index of the task to be deleted.
     */
    public static void findTask(TaskList taskList, String commandArgs) throws DukeException {
        int index = 0;
        ArrayList<Task> filteredTaskList = null;

        try {
            filteredTaskList = (ArrayList<Task>) taskList.getTasks().stream()
                    .filter((s) -> s.getDescription().contains(commandArgs))
                    .collect(toList());
            if (filteredTaskList.isEmpty()) {
                throw new DukeException(DukeException.EXCEPTION_MARK_ERROR);
            }
        } catch (Exception e) {
            throw new DukeException(DukeException.EXCEPTION_MARK_ERROR);
        }

        TextUi.printLine();
        TextUi.print("Here are the matching tasks in your list:");

        for (Task task : filteredTaskList) {
            TextUi.print(String.format("%d.", ++index)
                    + task.toString());
        }
    }
}
