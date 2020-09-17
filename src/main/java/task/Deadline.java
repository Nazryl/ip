package task;

import command.TextUi;

public class Deadline extends Task {

	protected String dueDate;

	public Deadline(String description, String dueDate) {
		super(description);
		this.dueDate = dueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	@Override
	public String toString() {
		return "[" + TextUi.TaskType.D + "]" + super.toString() + " (by: " + dueDate + ")";
	}
}
