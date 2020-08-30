import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private static final String COMMAND_TODO = "TODO";
    private static final String COMMAND_DEADLINE = "DEADLINE";
    private static final String COMMAND_EVENT = "EVENT";
    private static final String COMMAND_LIST = "LIST";
    private static final String COMMAND_BYE = "BYE";
    private static final String COMMAND_DONE = "DONE";

    private static final ArrayList<Task> taskList = new ArrayList<>();

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

    public static void addTask(String commandType, String commandArgs) {
        Task t = null;
        String[] splitArgs;
        printLine();

        switch (commandType.toUpperCase()) {
        case COMMAND_TODO:
            t = new Todo(commandArgs);
            taskList.add(t);
            break;
        case COMMAND_DEADLINE:
            splitArgs = commandArgs.split("/by ", 2);
            t = new Deadline(splitArgs[0], splitArgs[1]);
            taskList.add(t);
            break;
        case COMMAND_EVENT:
            splitArgs = commandArgs.split("/at ", 2);
            t = new Event(splitArgs[0], splitArgs[1]);
            taskList.add(t);
            break;
        default:
        }
        
        System.out.println("Got it. I've added this task:");
        System.out.println(t);
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    public static void printList(ArrayList<Task> tasks) {
        int index = 0;
        printLine();
        System.out.println("Here are the tasks in your list:");

        for (Task task : tasks) {
            System.out.println(String.format("%d.", ++index)
                    + task.toString());
        }
    }

    public static void markTask(String commandArgs) {
        int num = Integer.parseInt(commandArgs);
        Task task = taskList.get(num-1);
        task.markDone();

        printLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String commandInput;

        printHello();

        loop: while (true) {
            commandInput = in.nextLine();
            String commandType = commandInput.split(" ")[0];
            String commandArgs = commandInput.substring(commandInput.indexOf(" ") + 1);

            switch (commandType.toUpperCase()) {
            case COMMAND_TODO:
            case COMMAND_DEADLINE:
            case COMMAND_EVENT:
                addTask(commandType, commandArgs);
                break;
            case COMMAND_LIST:
                printList(taskList);
                break;
            case COMMAND_BYE:
                printBye();
                break loop;
            case COMMAND_DONE:
                markTask(commandArgs);
                break;
            default:
            }

            printLine();
        }

    }

}
