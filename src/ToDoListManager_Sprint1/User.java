package ToDoListManager_Sprint1;

public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public void addTask(Task task) {
        taskList.addTask(task);
    }

    public void markTaskAsCompleted(String taskDescription) {
        taskList.markTaskAsCompleted(taskDescription);
    }

    public void printAllTasks() {
        System.out.println("To-Do List for " + name + ":");
        taskList.printAllTasks();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
