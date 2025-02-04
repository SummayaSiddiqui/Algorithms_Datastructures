package LinkedList.DoubleLinkedList;


/**
 * Implement an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowing for easy navigation
 * 1<>2<>3<>4<>5
 */


public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;
        private Node (T state) {
            this.state = state;
        }

    }
    private Node currentState;
    //Undo operation
    public T undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            return currentState.state;
        }
        System.out.println("No previous state to undo.");
        return null;
    }

    //perform an operation
    public void  addState (T newState) {
        Node newNode = new Node(newState);
        if (currentState == null) {
            currentState = newNode;
        } else {
            newNode.prev = currentState;
            currentState.next = newNode;
            currentState = newNode;
        }
        System.out.println("New state added: " + newState);
    }

    //Redo Operation
    public T redo(){
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            return currentState.state;
        }
        System.out.println("No next state to redo.");
        return null;
    }

    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();
        manager.addState("Ryan David");
        manager.addState("John Doe");
        manager.addState("Bob Smith");
        manager.addState("Dave Rio");

        System.out.println("Undo: " + manager.undo());
        System.out.println("Undo: " + manager.undo());
        System.out.println("Undo: " + manager.undo());
        System.out.println("Undo: " + manager.undo());

        System.out.println("Redo: " + manager.redo());
        System.out.println("Redo: " + manager.redo());
        System.out.println("Redo: " + manager.redo());
        System.out.println("Redo: " + manager.redo());
    }
}
