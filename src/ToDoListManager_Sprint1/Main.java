package ToDoListManager_Sprint1;

public class Main {
    public static void main(String[] args) {
    // Create an array of User objects
        User[] users = new User[3];

        users[0] = new User("John");
        users[1] = new User("Alice");
        users[2] = new User("Sean");

    // Add tasks to users' to-do lists
        users[0].addTask(new Task("Buy groceries"));
        users[0].addTask(new Task("Complete homework"));
        users[0].addTask(new Task("Clean the house"));

        users[1].addTask(new Task("Buy groceries"));
        users[1].addTask(new Task("Complete homework"));
        users[1].addTask(new Task("Clean the house"));

    // Print all tasks for John
        users[0].printAllTasks();

    // Mark a task as completed for John
        users[0].markTaskAsCompleted("Complete homework");

    // Print updated tasks for John
        users[0].printAllTasks();
        System.out.println("------------------------------------------");

    // Print all tasks for Alice
        users[1].printAllTasks();

    // Mark a task as completed for Alice
        users[1].markTaskAsCompleted("Buy groceries");

    // Print updated tasks for Alice
        users[1].printAllTasks();

    }
}
