package ToDoListManager_Sprint1;

public class TaskList {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    // THe list is initially empty
    public TaskList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markTaskAsCompleted(String taskDescription) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskDescription().equals(taskDescription)) {
                current.task.markAsCompleted();
                break;
            }
            current = current.next;
        }
    }

    public void printAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}
