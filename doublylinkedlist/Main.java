package doublylinkedlist;

public class Main {
    public static void main(String args[]) {
        // DoublyLinkedList myDLL = new DoublyLinkedList(7);

        // myDLL.getHead();
        // myDLL.getTail();
        // myDLL.getLength();
        // myDLL.printList();

        // APPEND
        // DoublyLinkedList myDLL = new DoublyLinkedList(1);

        // myDLL.append(2);
        // myDLL.printList();

        // REMOVE LAST
        // DoublyLinkedList myDLL = new DoublyLinkedList(1);
        // myDLL.append(2);

        // System.out.println(myDLL.removeLast().value);
        // System.out.println(myDLL.removeLast().value);
        // System.out.println(myDLL.removeLast());

        // PREPEND
        // DoublyLinkedList myDLL = new DoublyLinkedList(2);
        // myDLL.append(3);

        // myDLL.prepend(1);
        // myDLL.printList();

        // REMOVE FIRST
        // DoublyLinkedList myDLL = new DoublyLinkedList(2);
        // myDLL.append(1);

        // System.out.println(myDLL.removeFirst().value);
        // System.out.println(myDLL.removeFirst().value);
        // System.out.println(myDLL.removeFirst());

        // GET
        DoublyLinkedList myDLL = new DoublyLinkedList(0);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);

        System.out.println(myDLL.get(1).value);
        System.out.println(myDLL.get(2).value + "\n");

        myDLL.printList();

    }
}
