package task;

import util.TextUi;

public class Event extends Task {

    protected String scheduledDate;

    public Event(String description, String scheduledDate) {
        super(description);
        this.scheduledDate = scheduledDate;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    @Override
    public String toString() {
        return "[" + TextUi.TaskType.E + "]" + super.toString() + " (at: " + scheduledDate + ")";
    }
}
