public class Event extends Task {

	protected String scheduledDate;

	public Event(String description, String scheduledDate) {
		super(description);
		this.scheduledDate = scheduledDate;
	}

	@Override
	public String toString() {
		return "[" + TaskType.E + "]" + super.toString() + "(by: " + scheduledDate + ")";
	}
}
