import java.util.Scanner;

public class Duke {

    static final String COMMAND_BYE = "BYE";

    public static void printHello() {
        printLine();
        System.out.println("Greetings Peasants! I am the Almighty Allfather!");
        System.out.println("What can I do for you today?");
        printLine();
    }

    public static void printBye() {
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public static void printEcho(String echo) {
        printLine();
        System.out.println(echo);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputCommand;

        printHello();

        loop: while (true) {
            inputCommand = in.nextLine();

            switch (inputCommand.toUpperCase()) {
                case COMMAND_BYE:
                printBye();
                break loop;
            default:
                printEcho(inputCommand);
            }
            printLine();

        }

    }

}
