package linkedlist;

public class Main {

    public static void main(String args[]) {
        LinkedList myLinkedList = new LinkedList(1);

        // myLinkedList.getHead();
        // myLinkedList.getTail();
        // myLinkedList.getLength();

        // System.out.println("\nLinked List:");
        // myLinkedList.printList();

        myLinkedList.append(2);

        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast());
        
    }
}