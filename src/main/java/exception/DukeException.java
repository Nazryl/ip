package exception;

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

	private String message;

	public DukeException(String message) {
		super(message);
		this.message = message;
	}

	public void setException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
