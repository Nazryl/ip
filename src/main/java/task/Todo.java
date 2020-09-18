package task;

import util.TextUi;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[" + TextUi.TaskType.T + "]" + super.toString();
    }
}
