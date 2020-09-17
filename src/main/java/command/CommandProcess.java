package command;

import exception.*;
import task.*;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class CommandProcess {

    public static void CommandInput() {
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
                    addTask(commandArgs[0], commandArgs[1]);
                    break;
                case TextUi.COMMAND_LIST:
                    printList();
                    break;
                case TextUi.COMMAND_BYE:
                    TextUi.printBye();
                    commandInput = commandArgs[0].toUpperCase();
                    break;
                case TextUi.COMMAND_DONE:
                    markTask(commandArgs[1]);
                    break;
                case TextUi.COMMAND_DELETE:
                    deleteTask(commandArgs[1]);
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
            saveList();
        } while (!TextUi.COMMAND_BYE.equals(commandInput));
    }

    public static void addTask(String commandType, String commandArgs) {
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
                    TextUi.taskList.add(task);
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
                    TextUi.taskList.add(task);
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
                    TextUi.taskList.add(task);
                }
                break;
            default:
                throw new CommandException(DukeException.EXCEPTION_INVALID_COMMANDS);
            }
            TextUi.print("Got it. I've added this task:");
            System.out.println(task);
            TextUi.print("Now you have " + TextUi.taskList.size() + " tasks in the list.");
        } catch (DukeException e) {
            TextUi.print(e.toString());
        }
    }

    public static void deleteTask(String commandArgs) throws DukeException {
        int num = Integer.parseInt(commandArgs);
        Task task = null;

        try {
            task = TextUi.taskList.get(num - 1);
            TextUi.taskList.remove(task);

        } catch (Exception e) {
            throw new DukeException(DukeException.EXCEPTION_INVALID_DELETE);
        }

        TextUi.printLine();
        TextUi.print("Done! I've removed this task:");
        System.out.println(task);
        TextUi.print("Now you have " + TextUi.taskList.size() + " tasks in the list.");
    }

    public static void printList() {
        int index = 0;
        TextUi.printLine();
        TextUi.print("Here are the tasks in your list:");

        for (Task task : TextUi.taskList) {
            TextUi.print(String.format("%d.", ++index)
                    + task.toString());
        }
    }

    private static String generateString(Task t) {
        int statusBool = t.getStatusIcon().equals(TextUi.BOOLEAN_YES) ? TextUi.BOOLEAN_YES_NUM : TextUi.BOOLEAN_NO_NUM;

        switch (t.getClass().getSimpleName().toUpperCase()) {
        case TextUi.COMMAND_TODO:
            return TextUi.TaskType.T + " | " + statusBool + " | " + t.getDescription();
        case TextUi.COMMAND_DEADLINE:
            Deadline d = (Deadline) t;
            return TextUi.TaskType.D + " | " + statusBool + " | " + t.getDescription() + " | " + d.getDueDate();
        case TextUi.COMMAND_EVENT:
            Event e = (Event) t;
            return TextUi.TaskType.E + " | " + statusBool + " | " + t.getDescription() + " | " + e.getScheduledDate();
        default:
        }
        return "";
    }

    public static void markTask(String commandArgs) throws DukeException {
        int num = Integer.parseInt(commandArgs);
        Task task = null;

        try{
            task = TextUi.taskList.get(num - 1);
        } catch (Exception e) {
            throw new DukeException(DukeException.EXCEPTION_MARK_ERROR);
        }

        task.markDone();

        TextUi.printLine();
        TextUi.print("Nice! I've marked this task as done:");
        System.out.println(task);
    }

    public static void saveList() {
        try {
            File fileDirectory = new File(TextUi.FILE_DIR);
            FileWriter fw;

            if (!fileDirectory.exists()) {
                fileDirectory.mkdir();
            }

            fw = new FileWriter(TextUi.FILE_PATH);

            for (Task task : TextUi.taskList) {
                fw.write(generateString(task) + System.lineSeparator());
            }
            fw.close();
        } catch (Exception e) {
            TextUi.print(DukeException.EXCEPTION_FILE_SAVE_ERROR);
        }
    }

}
