import java.util.Arrays;
import java.util.Scanner;

public class Duke {

    static final String COMMAND_LIST = "LIST";
    static final String COMMAND_BYE = "BYE";
    static final int COMMAND_COUNT = 100;

    public static void printHello() {
        printLine();
        System.out.println("Greetings Peasants! I am the Almighty Allfather!");
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

    public static void printEcho(String echo) {
        printLine();
        System.out.println("added: " + echo);
    }

    public static void printList(String[] arrayList, int countList) {
        printLine();
        for (int i = 0; i < countList; i++) {
            System.out.println(i + 1 + ". " + arrayList[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputCommand;
        String[] storeList = new String[COMMAND_COUNT];
        int countList = 0;

        printHello();

        loop: while (true) {
            inputCommand = in.nextLine();

            switch (inputCommand.toUpperCase()) {
            case COMMAND_LIST:
                printList(storeList, countList);
                break;
            case COMMAND_BYE:
                printBye();
                break loop;
            default:
                storeList[countList] = inputCommand;
                printEcho(inputCommand);
                countList++;
            }

            printLine();
        }

    }

}
