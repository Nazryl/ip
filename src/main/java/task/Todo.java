package task;

import command.CommandVariables;

public class Todo extends Task {

	public Todo(String description) {
		super(description);
	}

	@Override
	public String toString() {
		return "[" + CommandVariables.TaskType.T + "]" + super.toString();
	}
}
