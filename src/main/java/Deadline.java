public class Deadline extends Task {

	protected String dueDate;

	public Deadline(String description, String dueDate) {
		super(description);
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "[" + TaskType.D + "]" + super.toString() + "(by: " + dueDate + ")";
	}
}
