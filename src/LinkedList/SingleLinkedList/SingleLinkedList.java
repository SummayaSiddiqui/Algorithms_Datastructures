package LinkedList.SingleLinkedList;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    //    create a linked list
    public Node createLinkedList(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    //  inserting linked list
    //  if the link doesn't exist
    //  inserting at the beginning
    //  inserting at the ending
    //  inserting at the anywhere

    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location <= size) {
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = node;
            node.next = nextNode;
        }
        size++;
    }


    //    Traverse a linked list
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        }
    }

    //    search for a node
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println(
                            "Found the node: " + tempNode.value + " at location: " + i + "\n"
                    );
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    //  deleting linked list
    //  if the list doesn't exist
    //  deleting at the beginning
    //  deleting at the ending
    //  deleting anywhere
    public void deleteLinkedList(int location) {
        if (head == null) {
            System.out.println("The linked list does not exist.");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                System.out.println("There was only one node in the list, hence it is deleted");
            } else {
                head = head.next;
                System.out.println("Node deleted at the beginning");
            }
        } else if (location == size - 1) {
            Node tempNode = head;
            while (tempNode.next != tail) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            tail = tempNode;
            System.out.println("Node deleted at the end");
        } else if (location > 0 && location < size - 1) {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            System.out.println("Node deleted at location " + location);
        } else {
            System.out.println("Invalid location as no node lies at location " + location);
            return;
        }
        size--;
    }
}

