package task;

import util.TextUi;

/**
 * Represents a event that extends from the <code>Task</code> class.
 * It contains additional <code>at</code>
 * attribute that which represents the date of the event.
 */
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
