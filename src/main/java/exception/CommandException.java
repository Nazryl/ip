package exception;

/**
 * Exception for commands typed by user cannot be found.
 */
public class CommandException extends DukeException {

    public CommandException(String message) {
        super(message);
    }
}
