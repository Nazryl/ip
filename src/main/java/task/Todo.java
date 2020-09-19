package task;

import util.TextUi;

/**
 * Represents a todo task that extends from the <code>Task</code> class.
 */
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[" + TextUi.TaskType.T + "]" + super.toString();
    }
}
