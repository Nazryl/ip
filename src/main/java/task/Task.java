package task;

public class Task {

	public static final String BOOLEAN_YES = "Y";
	public static final String BOOLEAN_NO = "N";
	protected String description;
	protected boolean isDone;

	public Task(String description) {
		this.description = description;
		this.isDone = false;
	}

	public String getDescription() {
		return description;
	}

	public String getStatusIcon() {
		return (isDone ? BOOLEAN_YES : BOOLEAN_NO);
	}

	public void markDone() {
		this.isDone = true;
	}

	@Override
	public String toString() {
		return "[" + getStatusIcon() + "] " + description;
	}
}
