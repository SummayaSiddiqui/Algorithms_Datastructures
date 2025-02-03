package LinkedList.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.insertLinkedList(11,0);
        sll.insertLinkedList(12,1);
        sll.insertLinkedList(13,2);
        sll.insertLinkedList(14,3);
        sll.insertLinkedList(15,4);

        sll.traverseLinkedList();
//        sll.searchNode(3);
//        sll.searchNode(15);

        sll.deleteLinkedList(0); // Delete the first node
        sll.traverseLinkedList();
//
        sll.deleteLinkedList(3);  // Delete last node
        sll.traverseLinkedList();
//
        sll.deleteLinkedList(1);  // Delete node at location 1
        sll.traverseLinkedList();

        sll.deleteLinkedList(5);
        sll.traverseLinkedList();// Invalid location (doesn't exist)
    }
}
