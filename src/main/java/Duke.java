import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    static final String COMMAND_LIST = "LIST";
    static final String COMMAND_BYE = "BYE";
    static final String COMMAND_DONE = "DONE";

    static ArrayList<Task> taskList = new ArrayList<>();

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

    public static void addTask(String echo) {
        printLine();
        Task task = new Task(echo);
        taskList.add(task);
        System.out.println("added: " + echo);
    }

    public static void printList(ArrayList<Task> tasks) {
        int index = 0;

        printLine();
        System.out.println("Here are the tasks in your list:");

        for (Task task : tasks) {
            System.out.println(String.format("%d.", ++index) + "[" + task.getStatusIcon() + "] " + task.description);
        }
    }

    public static void markTask(String inputCommand) {
        int num = Integer.parseInt(inputCommand.split(" ")[1]);
        Task task = taskList.get(num-1);
        task.markAsDone();

        printLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + task.getStatusIcon() + "] " + task.description);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputCommand;

        printHello();

        loop: while (true) {
            inputCommand = in.nextLine();
            String firstCommand = inputCommand.split(" ")[0];

            switch (firstCommand.toUpperCase()) {
            case COMMAND_LIST:
                printList(taskList);
                break;
            case COMMAND_BYE:
                printBye();
                break loop;
            case COMMAND_DONE:
                markTask(inputCommand);
                break;
            default:
                addTask(inputCommand);
            }

            printLine();
        }

    }

}
