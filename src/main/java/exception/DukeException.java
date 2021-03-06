package exception;

/**
 * Extends from Exception class and constitutes exceptions in AllFather.
 * Stores all error messages.
 */
public class DukeException extends Exception {
    public static final String EXCEPTION_MISSING_COMMANDS = "OOPS!!! Enter for me commands!";
    public static final String EXCEPTION_INVALID_COMMANDS = "OOPS!!! Enter for me valid commands!";
    public static final String EXCEPTION_MISSING_TASK = "OOPS!!! I need to know your task!";
    public static final String EXCEPTION_MISSING_DATE = "OOPS!!! I need to know /by which date!";
    public static final String EXCEPTION_MISSING_EVENT = "OOPS!!! I need to know your event!";
    public static final String EXCEPTION_MISSING_TIME = "OOPS!!! I need to know /at what time!";
    public static final String EXCEPTION_INVALID_DELETE = "OOPS!!! Enter a valid task to delete!";
    public static final String EXCEPTION_FILE_SAVE_ERROR = "OOPS!!! File fail to save!";
    public static final String EXCEPTION_FILE_LOAD_ERROR = "OOPS!!! File not found!";
    public static final String EXCEPTION_MARK_ERROR = "OOPS!!! Task not found!";
    public static final String EXCEPTION_INVALID_DATETIME = "OOPS!!! Enter for me a valid date and time!";

    private String message;

    public DukeException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
