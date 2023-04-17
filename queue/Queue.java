package queue;

// We use a Singly linked-linked list to represent a Queue
// FIFO system
public class Queue {
    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getFirst() {
        System.out.println("First: " + first.value);
    }

    public void getLast() {
        System.out.println("Length: " + length);
    }

    public void getLength() {
        System.out.println("Last: " + last.value);
    }

    // To Enqueue is to add from the end (last)
    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    // Dequeue: Remove the first item
    public Node dequeue() {
        // Empty queue
        if (length == 0) return null;

        Node temp = first;

        // If 1 item in the queue
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;

        return temp;
    }
}
