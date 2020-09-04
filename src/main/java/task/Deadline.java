package task;

import command.CommandVariables;

public class Deadline extends Task {

	protected String dueDate;

	public Deadline(String description, String dueDate) {
		super(description);
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "[" + CommandVariables.TaskType.D + "]" + super.toString() + "(by: " + dueDate + ")";
	}
}
