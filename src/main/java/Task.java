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
		return (isDone ? "Y" : "N");
	}

	public void markDone() {
		this.isDone = true;
	}

	@Override
	public String toString() {
		return "[" + getStatusIcon() + "] " + description;
	}
}