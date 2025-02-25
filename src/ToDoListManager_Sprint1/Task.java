package ToDoListManager_Sprint1;

public class Task {
    private String taskDescription;
    private boolean status;

    public Task(String task){
        this.taskDescription = taskDescription;
        this.status = false;
    }

    public void markAsCompleted() {
        this.status = true;
    }

    // getters
    public String getTask() {
        return taskDescription;
    }

    public boolean isCompleted() {
        return status;
    }

    // setters
    public void setTask(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[ " + (status ? "Completed" : "Pending") + " ] " + taskDescription;
    }
}
