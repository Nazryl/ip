package task;

import command.TextUi;

public class Todo extends Task {

	public Todo(String description) {
		super(description);
	}

	@Override
	public String toString() {
		return "[" + TextUi.TaskType.T + "]" + super.toString();
	}
}
