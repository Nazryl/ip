package task;

import util.TextUi;

/**
 * Represents a deadline task that extends from the <code>Task</code> class.
 * It contains additional <code>by</code>
 * attribute which represents the due date of the task.
 */
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
