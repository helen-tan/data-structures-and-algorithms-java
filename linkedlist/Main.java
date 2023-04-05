package linkedlist;

public class Main {

    public static void main(String args[]) {
        // LinkedList myLinkedList = new LinkedList(1);

        // myLinkedList.getHead();
        // myLinkedList.getTail();
        // myLinkedList.getLength();

        // System.out.println("\nLinked List:");
        // myLinkedList.printList();

        // APPEND
        // myLinkedList.append(2);

        // System.out.println(myLinkedList.removeLast().value);
        // System.out.println(myLinkedList.removeLast().value);
        // System.out.println(myLinkedList.removeLast());

        // PREPEND
        // LinkedList myLinkedList = new LinkedList(2);
        // myLinkedList.append(3);

        // myLinkedList.prepend(1);

        // myLinkedList.printList();

        // REMOVE FIRST
        // LinkedList myLinkedList = new LinkedList(2);
        // myLinkedList.append(1);

        // System.out.println(myLinkedList.removeFirst().value); // 2 items
        // System.out.println(myLinkedList.removeFirst().value); // 1 item
        // System.out.println(myLinkedList.removeFirst());       // 0 items

        // Get a node at a specific index
        // LinkedList myLinkedList = new LinkedList(0);
        // myLinkedList.append(1);
        // myLinkedList.append(2);
        // myLinkedList.append(3);

        // System.out.println(myLinkedList.get(2).value + "\n");

        // myLinkedList.printList();

        // Set the value of a node at a specific index
        LinkedList myLinkedList = new LinkedList(11);
        myLinkedList.append(3);
        myLinkedList.append(23);
        myLinkedList.append(7);

        myLinkedList.set(1, 4);

        myLinkedList.printList();

    }
}
