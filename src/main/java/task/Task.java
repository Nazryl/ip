package task;

import command.CommandVariable;

public class Task {

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
		return (isDone ? CommandVariable.BOOLEAN_YES : CommandVariable.BOOLEAN_NO);
	}

	public void markDone() {
		this.isDone = true;
	}

	@Override
	public String toString() {
		return "[" + getStatusIcon() + "] " + description;
	}
}
